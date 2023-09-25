package com.example.ecommerceapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import adapter.Sub_cat_adapter;
import adapter.Subcat2;
import bottomcategories.Categories1;
import bottomcategories.Categories2;
import bottomcategories.Categories3;

public class category extends Fragment {

    Categories1 categories1;
    Categories2 categories2;
    Categories3 categories3;
    RequestQueue queue1, queue2, queue3;
    ArrayList<Modelclass> arrayList1, arrayList2, arrayList3;
    RecyclerView recyclerView, recyclerView22, recyclerView125;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar1);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ...

        setToolbarTitle("All Categories"); // Apna title yahan daalein

// Inside the onCreateView method of Product fragment

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous Fragment
                getFragmentManager().popBackStack();
            }
        });

        queue1 = Volley.newRequestQueue(getContext());
        recyclerView = view.findViewById(R.id.recyclerView1);
        arrayList1 = new ArrayList<>();
        String url2 = "http://www.gurjeetsingh.store/webservice1.asmx/Categories1";
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Toast.makeText(getContext(), "sucess" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name1 = jsonObject.getString("name");
                                String image2 = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setSlidername(name1);
                                modelclass.setSliderimage(image2);
                                arrayList1.add(modelclass);
                                categories1 = new Categories1(getContext(), arrayList1);
                                recyclerView.setAdapter(categories1);
                                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
                                recyclerView.setLayoutManager(layoutManager);

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
        queue2 = Volley.newRequestQueue(getContext());
        recyclerView22 = view.findViewById(R.id.recycle2);
        arrayList2 = new ArrayList<>();
        String url3 = "http://www.gurjeetsingh.store/webservice1.asmx/Categories2";
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Toast.makeText(getContext(), "sucess" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name11 = jsonObject.getString("name");
                                String image22 = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setSlidername(name11);
                                modelclass.setSliderimage(image22);
                                arrayList2.add(modelclass);
                                categories2 = new Categories2(getContext(), arrayList2);
                                recyclerView22.setAdapter(categories2);
                                //  GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);

                                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                                recyclerView22.setLayoutManager(layoutManager);

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
        queue3 = Volley.newRequestQueue(getContext());
        recyclerView125 = view.findViewById(R.id.recycle26);
        arrayList3 = new ArrayList<>();
        String url4 = "http://www.gurjeetsingh.store/webservice1.asmx/Categories3";
        StringRequest stringRequest6 = new StringRequest(Request.Method.GET, url4,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Toast.makeText(getContext(), "ffvxcvfvsvsdv" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                  String name111 = jsonObject.getString("name");
                                String image222 = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                  modelclass.setSlidername(name111);
                                modelclass.setSliderimage(image222);
                                arrayList3.add(modelclass);
                                categories3 = new Categories3(getContext(), arrayList3);
                                recyclerView125.setAdapter(categories3);
                                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

                                // LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                                recyclerView125.setLayoutManager(layoutManager);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue1.add(stringRequest1);
        queue2.add(stringRequest2);
        queue3.add(stringRequest6);
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