package com.example.ecommerceapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
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

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Clickevent.Clickevent;
import adapter.Home_category_adapter;
import adapter.Homeadapterimage;
import adapter.Homeadater3;
import adapter.ImageSliderAdapter;
import adapter.Testadapter;

public class Home_fragment extends Fragment {

    Home_category_adapter home_category_adapter;
    Testadapter testadapter;
    Homeadapterimage imgadapter;
    Homeadater3 homeadater3;
    // ImageSliderAdapter imageSliderAdapter;
    ImageCarousel carousel;
    RequestQueue queue, queue2, queue3, queue4;
    ArrayList<Modelclass> arrayList, arrayList2, arrayList3, arrayList4;
    RecyclerView recyclerViewww, recyclerView, recyclerView3;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);


        arrayList2 = new ArrayList<>();
        carousel = view.findViewById(R.id.carousel);

        String slider = "http://www.gurjeetsingh.store/Webservice1.asmx/slider";
        queue2 = Volley.newRequestQueue(getContext());

        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, slider,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //    Toast.makeText(getContext(), "kkkkkk" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String images = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setImageslider(images);
                                arrayList2.add(modelclass);
                                carousel.addData(new CarouselItem(images));
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
        queue = Volley.newRequestQueue(getContext());
        recyclerViewww = view.findViewById(R.id.recycleview2);
        arrayList = new ArrayList<>();

        String categoryurl = "http://www.gurjeetsingh.store/webservice1.asmx/CategoryApi";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, categoryurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //    Toast.makeText(getContext(), "kkkkkk" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int id = jsonObject.getInt("catid");
                                String name = jsonObject.getString("catname");
                                String image = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("catimage");
                                modelclass.setCategoreyname(name);
                                modelclass.setCategoreyimage(image);
                                modelclass.setId(id);
                                arrayList.add(modelclass);
                                home_category_adapter = new Home_category_adapter(getContext(), arrayList);
                              //  recyclerViewww.setAdapter(Testadapter);

                                testadapter = new Testadapter(getContext(),arrayList);
                                recyclerViewww.setAdapter(home_category_adapter);

                                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                                recyclerViewww.setLayoutManager(layoutManager);
                                home_category_adapter.setonItemClickForRec(new Clickevent() {
                                    @Override
                                    public void GetItemPos(int pos) {

                                        switch (pos){
                                            case 0:
                                                getFragmentManager().beginTransaction().replace(R.id.second, new Cat_subcategory(arrayList.get(pos).getId())).addToBackStack(null).commit();
                                                break;
                                            case 1:
                                                getFragmentManager().beginTransaction().replace(R.id.second, new BlankFragment(arrayList.get(pos).getId())).addToBackStack(null).commit();
                                                break;
                                        }

                                      //  getFragmentManager().beginTransaction().replace(R.id.second, new Cat_subcategory(arrayList.get(pos).getId())).addToBackStack(null).commit();
                                        //  Context context;
                                       /* Intent intent = new Intent(getContext(), Cat_subcategory.class);
                                        getContext() .startActivity(intent);*/


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
            }
        });
        queue3 = Volley.newRequestQueue(getContext());
        recyclerView = view.findViewById(R.id.homeimgrecycler);
        arrayList3 = new ArrayList<>();

        String imggurl = "http://www.gurjeetsingh.store/webservice1.asmx/homepage";
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
                                String imageee = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setImg(imageee);
                                arrayList3.add(modelclass);
                                imgadapter = new Homeadapterimage(getContext(), arrayList3);

                                recyclerView.setAdapter(imgadapter);
                                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
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


        queue4 = Volley.newRequestQueue(getContext());
        recyclerView3 = view.findViewById(R.id.view4);
        arrayList4 = new ArrayList<>();

        String url = "http://www.gurjeetsingh.store/webservice1.asmx/homeitem4";
        StringRequest stringRequest4 = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                          //  Toast.makeText(getContext(), "bkgkhjh" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Modelclass modelclass = new Modelclass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String mages = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("image");
                                modelclass.setImg4(mages);
                                arrayList4.add(modelclass);
                                homeadater3 = new Homeadater3(getContext(), arrayList4);

                                recyclerView3.setAdapter(homeadater3);
                                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                                recyclerView3.setLayoutManager(layoutManager);

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


// Add the request to the RequestQueue.
        queue.add(stringRequest);
        queue2.add(stringRequest2);
        queue3.add(stringRequest3);
        queue4.add(stringRequest4);

        return view;
    }
}