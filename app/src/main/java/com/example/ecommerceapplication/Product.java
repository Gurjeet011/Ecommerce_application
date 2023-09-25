package com.example.ecommerceapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import Clickevent.Subcat_clickevent;
import adapter.Product_adapter;
import adapter.Sub_cat_adapter;

public class Product extends Fragment {
    Product_adapter product_adapter;
    RequestQueue queue;
    ArrayList<Modelclass> arrayList;
    RecyclerView recyclerproduct;
    int pos;
    public Product(int pos) {
        // Required empty public constructor
        this.pos=pos;




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product, container, false);
      //  TextView textView=view.findViewById(R.id.gagan);
       // textView.setText(""+pos);
         queue = Volley.newRequestQueue(getContext());
        recyclerproduct = view.findViewById(R.id.productrecyclerview);
        arrayList = new ArrayList<>();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ...

        setToolbarTitle("T-shirt"); // Apna title yahan daalein

// Inside the onCreateView method of Product fragment

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous Fragment
                getFragmentManager().popBackStack();
            }
        });


        String url = "http://www.gurjeetsingh.store/Webservice1.asmx/prod?id="+pos;
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
                                int pid = jsonObject.getInt("pid");
                                //  String quantity = jsonObject.getString("quantity");
                                String name = jsonObject.getString("name");
                                String offerdis = jsonObject.getString("discountoffer");

                                String originalprice = jsonObject.getString("oriprice");
                                String discoutprice = jsonObject.getString("disprice");
                                String des = jsonObject.getString("description");

                                String image = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setBrandname(name);
                                // modelclass.setItemproduct(quantity);
                                modelclass.setOriginalprice(originalprice);
                                modelclass.setDiscountprice(discoutprice);
                                modelclass.setDescription(des);
                                modelclass.setDisoffer(offerdis);

                                modelclass.setSubcattext(image);
                                modelclass.setPid(pid);
                                arrayList.add(modelclass);

                                product_adapter = new Product_adapter(getContext(), arrayList);
                                recyclerproduct.setAdapter(product_adapter);
                                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                                recyclerproduct.setLayoutManager(layoutManager);
                                product_adapter.setonItemClickForRec(new Clickevent() {
                                    @Override
                                    public void GetItemPos(int pos) {
                                        getFragmentManager().beginTransaction().replace(R.id.third, new Description(arrayList.get(pos).getPid())).addToBackStack(null).commit();
                                        Toast.makeText(getContext(), "jjjjj", Toast.LENGTH_SHORT).show();
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
                Toast.makeText( getContext(), "error", Toast.LENGTH_SHORT).show();
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
