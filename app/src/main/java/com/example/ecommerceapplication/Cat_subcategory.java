package com.example.ecommerceapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;


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
import adapter.Sub_cat_adapter;
import adapter.Subcat2;
import adapter.Subcat3;
import adapter.Subcat4;

public class Cat_subcategory extends Fragment {
    Sub_cat_adapter sub_cat_adapter;
    Subcat2 subcat2;
    Subcat3 subcat3;
    Subcat4 subcat4;
    RequestQueue queue1, queue3,queue2,queue4;
    ArrayList<Modelclass> arrayList3, arrayList,arrayList2,arrayList4;
    RecyclerView recyclerviwsubcat,recyclerView56,recyclerView85;
    ViewPager2 viewPager2;

    int pos;
    private Handler autoSlideHandler = new Handler();
    private final int AUTO_SLIDE_DELAY = 3000; // Adjust the delay as needed
    private Runnable autoSlideRunnable;

    public Cat_subcategory(int pos) {
        // Required empty public constructor
        this.pos = pos;


    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_cat_subcategory, null, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar74);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ...

        setToolbarTitle("Men"); // Apna title yahan daalein

// Inside the onCreateView method of Product fragment

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous Fragment
                getFragmentManager().popBackStack();
            }
        });
        queue1 = Volley.newRequestQueue(getContext());
        recyclerviwsubcat = view.findViewById(R.id.recycleviewSub_cat);
        arrayList3 = new ArrayList<>();
        String url = "http://www.gurjeetsingh.store/webservice1.asmx/Subcategoryapi?id=" + pos;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //   Toast.makeText(getContext(), "sucess" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int sid = jsonObject.getInt("sid");
                                String name = jsonObject.getString("name");
                                String image = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setSubcatimages(name);
                                modelclass.setSubcattext(image);
                                modelclass.setSid(sid);
                                arrayList3.add(modelclass);
                                sub_cat_adapter = new Sub_cat_adapter(getContext(), arrayList3);
                                recyclerviwsubcat.setAdapter(sub_cat_adapter);
                                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 5);
                                recyclerviwsubcat.setLayoutManager(layoutManager);
                                sub_cat_adapter.setonItemClickForRec(new Clickevent() {
                                    @Override
                                    public void GetItemPos(int pos) {
                                        getFragmentManager().beginTransaction().replace(R.id.second, new Product(arrayList3.get(pos).getSid())).addToBackStack(null).commit();
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

        queue2 = Volley.newRequestQueue(getContext());
        recyclerView56 = view.findViewById(R.id.recycleview3);
        arrayList2 = new ArrayList<>();
        String url5 = "http://www.gurjeetsingh.store/webservice1.asmx/Subcat3?id=" + pos;
        StringRequest stringRequest6 = new StringRequest(Request.Method.GET, url5,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //   Toast.makeText(getContext(), "sucess" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                               // int sid = jsonObject.getInt("sid");
                              //  String named = jsonObject.getString("name");
                                String imaged = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                              //  modelclass.setSubcatimages(named);
                                modelclass.setSliderimage(imaged);
                             //   modelclass.setSid(sid);
                                arrayList2.add(modelclass);
                                subcat3 = new Subcat3(getContext(), arrayList2);
                                recyclerView56.setAdapter(subcat3);
                                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

                                recyclerView56.setLayoutManager(layoutManager);
                               /* sub_cat_adapter.setonItemClickForRec(new Clickevent() {
                                    @Override
                                    public void GetItemPos(int pos) {
                                        getFragmentManager().beginTransaction().replace(R.id.second, new Product(arrayList3.get(pos).getSid())).addToBackStack(null).commit();
                                    }
                                });*/
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
        viewPager2 = view.findViewById(R.id.viewPager);
        arrayList = new ArrayList<>();
        String url2 = "http://www.gurjeetsingh.store/webservice1.asmx/Subcat2?id=" + pos ;
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2,
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
                                Log.d("NameDebug", "Name: " + name1);
                                String image2 = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setSlidername(name1);
                                modelclass.setSliderimage(image2);
                                arrayList.add(modelclass);
                                subcat2 = new Subcat2(getContext(), arrayList); // Create adapter instance
                                viewPager2.setAdapter(subcat2);

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
        queue4 = Volley.newRequestQueue(getContext());
        recyclerView85 = view.findViewById(R.id.recyclerView9);
        arrayList4 = new ArrayList<>();
        String url4 = "http://www.gurjeetsingh.store/webservice1.asmx/Subcat4?id=" + pos;
        StringRequest stringRequest4 = new StringRequest(Request.Method.GET, url4,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //   Toast.makeText(getContext(), "sucess" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String imagem = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setSliderimage(imagem);

                                arrayList4.add(modelclass);
                                subcat4 = new Subcat4(getContext(), arrayList4);
                                recyclerView85.setAdapter(subcat4);
                                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                                recyclerView85.setLayoutManager(layoutManager);

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

        queue1.add(stringRequest);
        queue3.add(stringRequest2);
        queue2.add(stringRequest6);
        queue4.add(stringRequest4);

        autoSlideRunnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager2.getCurrentItem();
                int itemCount = subcat2.getItemCount();
                int nextItem = (currentItem + 1) % itemCount;
                viewPager2.setCurrentItem(nextItem);
                autoSlideHandler.postDelayed(this, AUTO_SLIDE_DELAY);
            }
        };
        // Start auto sliding
        autoSlideHandler.postDelayed(autoSlideRunnable, AUTO_SLIDE_DELAY);

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

    @Override
    public void onPause() {
        super.onPause();
        // Stop auto sliding
        autoSlideHandler.removeCallbacks(autoSlideRunnable);
    }
}

