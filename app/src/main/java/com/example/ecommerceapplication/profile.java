package com.example.ecommerceapplication;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.EditTextPreference;
import android.util.Log;
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

import adapter.Homeadapterimage;
import adapter.Product_adapter;
import adapter.Profileadapter;


public class profile extends Fragment {
    Profileadapter profileadapter;

    RecyclerView recyclerView;
    ArrayList<Modelclass> arrayList;
    Button btn;
    TextView txt;
    RequestQueue requestQueue,requestQueue2;
    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        btn=view.findViewById(R.id.logout);
        txt=view.findViewById(R.id.name);
        requestQueue= Volley.newRequestQueue(getActivity());
        sharedPreferences = getActivity().getSharedPreferences("session", MODE_PRIVATE);


        String name = sharedPreferences.getString("key", "0");


      // Toast.makeText(getContext(),"id is="+id,Toast.LENGTH_LONG).show();
        String url = "http://www.gurjeetsingh.store/Webservice1.asmx/profile_api?email="+name;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                       Toast.makeText(getContext(),"suceess"+response,Toast.LENGTH_LONG).show();
                        JSONArray jsonArray= null;
                        try {
                            jsonArray = new JSONArray(response);
                            JSONObject jsonObject=jsonArray.getJSONObject(0);
                            String n=jsonObject.getString("name");
                            String id=jsonObject.getString("userid");

                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("userid",id);
                            editor.apply();
                          txt.setText(n);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle the error

                     //   Toast.makeText(getContext(),""+error.getMessage(),Toast.LENGTH_LONG).show();
                        Log.d("Api Error", "onErrorResponse: "+error.getMessage());


                    }
                });

        requestQueue.add(stringRequest);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("key");
                editor.apply();

                Intent intent = new Intent(getActivity(), loginactivity.class);
                startActivity(intent);
                getActivity().finish();


                }

        });

//profile api


        requestQueue2 = Volley.newRequestQueue(getContext());
       recyclerView = view.findViewById(R.id.recycleaccount);
        arrayList = new ArrayList<>();


        String imggurl = "http://www.gurjeetsingh.store/webservice1.asmx/account";
        StringRequest stringRequest3 = new StringRequest(Request.Method.GET, imggurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //    Toast.makeText(getContext(), "kiddddd" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name = jsonObject.getString("name");

                                String imageee = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setSliderimage(imageee);
                                modelclass.setSlidername(name);

                                arrayList.add(modelclass);
                                profileadapter = new Profileadapter(getContext(), arrayList);
                                profileadapter.setRecyclerViewDivider(recyclerView);


                                recyclerView.setAdapter(profileadapter);
                                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                                recyclerView.setLayoutManager(layoutManager);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });



        requestQueue2.add(stringRequest3);


        return view;
    }
}