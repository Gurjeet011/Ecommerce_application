package com.example.ecommerceapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
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

import Clickevent.Clickevent;
import adapter.Sub_cat_adapter;
import adapter.Subcat2;
import adapter.Testadapter;


public class BlankFragment extends Fragment {

    Testadapter testadapter;
    RequestQueue queue3, queue;
    ArrayList<Modelclass> arrayList3, arrayList;
    RecyclerView recyclerviwsubcat;
    int pos;
    public BlankFragment(int pos) {
        // Required empty public constructor
        this.pos = pos;


    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        queue3 = Volley.newRequestQueue(getContext());
        recyclerviwsubcat = view.findViewById(R.id.gagan_recyclerview);
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
                                modelclass.setSlidername(name);
                                modelclass.setSliderimage(image);
                                modelclass.setSid(sid);
                                arrayList3.add(modelclass);
                                testadapter = new Testadapter(getContext(), arrayList3);
                                recyclerviwsubcat.setAdapter(testadapter);
                                GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 5);
                                recyclerviwsubcat.setLayoutManager(layoutManager);

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

        queue3.add(stringRequest);
    return view;
    }
}