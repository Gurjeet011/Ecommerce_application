package com.example.ecommerceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class loginactivity extends AppCompatActivity {
    TextInputLayout email,pass;
    Button btn,btn2;
    RequestQueue requestQueue;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        requestQueue= Volley.newRequestQueue(this);
        sharedPreferences=getSharedPreferences("session",MODE_PRIVATE);
        String name=sharedPreferences.getString("key","0");
        if(name!="0")
        {
            startActivity(new Intent(this,Lottie.class));
            finish(); // close app code not show in login page
        }
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        btn=findViewById(R.id.buttonlogin);
        btn2=findViewById(R.id.register);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginactivity.this, MainActivity.class);


                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e= email.getEditText().getText().toString();
                String p= pass.getEditText().getText().toString();

                String url="http://www.gurjeetsingh.store/WEbservice1.asmx/LoginPageApi?email="+e+"&password="+p;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {


                                    JSONArray jsonArray=new JSONArray(response);

                                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                                    String name=jsonObject.getString("msg");

                                    if(name.equals("1"))
                                    {
                                        SharedPreferences.Editor editor=sharedPreferences.edit();
                                        editor.putString("key",""+e);
                                        editor.apply();
                                        startActivity(new Intent(loginactivity.this,Lottie.class));
                                        finish();
                                        Toast.makeText(loginactivity.this, "Sucess fully Login" + response, Toast.LENGTH_SHORT).show();
                                       /* Intent intent = new Intent(loginactivity.this, Homepage.class);
                                        startActivity(intent);*/
                                    }
                                    else{

                                        Toast.makeText(loginactivity.this, "not valid", Toast.LENGTH_SHORT).show();


                                    }
                                } catch (JSONException ex) {
                                    ex.printStackTrace();
                                }


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(loginactivity.this,"fefe"+error.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
                requestQueue.add(stringRequest);

// Add the request to the RequestQueue.
            }


        });


    }
}