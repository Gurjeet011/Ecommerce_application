package com.example.ecommerceapplication;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import java.util.Queue;

import adapter.Displaycart;

public class notification extends Fragment {
    Displaycart cart;
   RequestQueue queue;
    ArrayList arrayList;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_notification, container, false);


        recyclerView = view.findViewById(R.id.addcart);
        arrayList = new ArrayList<>();
        queue = Volley.newRequestQueue(getContext());

        sharedPreferences = getContext().getSharedPreferences("session", MODE_PRIVATE);
        String n = sharedPreferences.getString("userid", "0");

        Toast.makeText(getContext(),""+n,Toast.LENGTH_LONG).show();


        String url = "http://www.gurjeetsingh.store/webservice1.asmx/displayitem?userid=" + n;

// Request a string response from the provided URL.
      //  Toast.makeText(getContext(), "bkgkhjh" , Toast.LENGTH_LONG).show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Display the first 500 characters of the response string.
                        try {
                           // Toast.makeText(getContext(), "bkgkhjh" + response, Toast.LENGTH_LONG).show();

                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String Nam = jsonObject.getString("cartname");
                                // jid = jsonObject.getString("id");
                                int ddid = jsonObject.getInt("id");

                                String pric = jsonObject.getString("cartprice");
                                String pric2 = jsonObject.getString("cartdes");

                                String imagem = "http://www.gurjeetsingh.store/upload/" + jsonObject.getString("cartimage");
                                Log.d("MyCustomTag", imagem); // छवि URL को प्रिंट करें

                                Modelclass modelclass = new Modelclass();
                                modelclass.setDesname(Nam);
                             //   modelclass.getDesname(itmid);
                                modelclass.setDespriceori(pric);
                                modelclass.setImg(imagem);

                                modelclass.setDid(ddid);

                                modelclass.setDespricedis(pric2);
                                arrayList.add(modelclass);
                                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                                layoutManager.setOrientation(layoutManager.VERTICAL);
                                recyclerView.setLayoutManager(layoutManager);
                                cart = new Displaycart(getContext(), arrayList);
                                recyclerView.setAdapter(cart);
                              /*  cart  = new Displaycart(getContext(), arrayList);
                                recyclerView.setAdapter(cart);

                                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

                                layoutManager.setOrientation(layoutManager.VERTICAL);
                                recyclerView.setLayoutManager(layoutManager);
*/

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "vvhjffhfhfj" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        return view;
    }
}