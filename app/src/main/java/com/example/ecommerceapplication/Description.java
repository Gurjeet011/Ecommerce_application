package com.example.ecommerceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Clickevent.Clickevent;
import adapter.Description_adapter;
import adapter.Product_adapter;

public class Description extends Fragment {
    Description_adapter description_adapter;
    RequestQueue queue, queue2;
    ArrayList<Modelclass> arrayList;
    RecyclerView desrecycler;
    Button btn;
    SharedPreferences sharedPreferences;

    String name;
    String oriprice;
    String image;
    String disprice;


    // TextView demo;
    int pos;

    public Description(int pos) {
        // Required empty public constructor
        this.pos = pos;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbarcart);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setToolbarTitle("Products");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous Fragment
                getFragmentManager().popBackStack();
            }
        });


        queue = Volley.newRequestQueue(getContext());
        desrecycler = view.findViewById(R.id.description);
        arrayList = new ArrayList<>();


        sharedPreferences = getContext().getSharedPreferences("session", Context.MODE_PRIVATE);
        String n = sharedPreferences.getString("userid", "0");
        //   Toast.makeText(getContext(),""+n,Toast.LENGTH_LONG).show();
        btn = view.findViewById(R.id.addtocartbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue2 = Volley.newRequestQueue(getContext());
                String url = "http://www.gurjeetsingh.store/Webservice1.asmx/addtocart?cartname=" + name + "&cartimage=" + image + "&cartprice=" + oriprice + "&cartdes=" + disprice + "&userid=" + n;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getContext(), "add to cart successfully." + response, Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "error" + error, Toast.LENGTH_SHORT).show();
                    }
                });

// Add the request to the RequestQueue.

                queue2.add(stringRequest);
            }
        });


        String url = "http://www.gurjeetsingh.store/Webservice1.asmx/description?id=" + pos;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //   Toast.makeText(getContext(), "bbbbbbbbbbbb" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int pid = jsonObject.getInt("did");
                                //  String quantity = jsonObject.getString("quantity");
                                name = jsonObject.getString("disname");
                                oriprice = jsonObject.getString("dismrpprice");
                                disprice = jsonObject.getString("dissaveprice");

                                image = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("disimage");
                                modelclass.setDesname(name);
                                // modelclass.setItemproduct(quantity);
                                modelclass.setDespriceori(oriprice);
                                modelclass.setDespricedis(disprice);

                                modelclass.setDesimage(image);
                                modelclass.setDid(pid);
                                arrayList.add(modelclass);

                                description_adapter = new Description_adapter(getContext(), arrayList);
                                desrecycler.setAdapter(description_adapter);
                                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
                                desrecycler.setLayoutManager(layoutManager);
                                description_adapter.setonItemClickForRec(new Clickevent() {
                                    @Override
                                    public void GetItemPos(int pos) {
                                        getFragmentManager().beginTransaction().replace(R.id.cart, new Cart(arrayList.get(pos).getPid())).addToBackStack(null).commit();
                                        //  Toast.makeText(getContext(), "jjjjj", Toast.LENGTH_SHORT).show();
                                    }


                                });

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.

        queue.add(stringRequest);


        return view;
    }

    private void setToolbarTitle(String title) {
        if (getActivity() != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            if (activity != null && activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle(title);
            }
        }
    }
}