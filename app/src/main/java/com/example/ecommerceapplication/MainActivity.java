package com.example.ecommerceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextInputLayout namee,email,pass,mobile;
    Button btn;
    TextView loginn;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue= Volley.newRequestQueue(this);
        loginn=findViewById(R.id.login);
        namee=findViewById(R.id.tilUserName);
        email=findViewById(R.id.tilUserEmail);
        pass=findViewById(R.id.tilUserPassword);
        mobile=findViewById(R.id.tilUserMobile);
        btn=findViewById(R.id.button);
        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, loginactivity.class);


                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n= namee.getEditText().getText().toString();
                String e= email.getEditText().getText().toString();
                String p= pass.getEditText().getText().toString();
                String m=mobile.getEditText().getText().toString();

                String url= "http://www.gurjeetsingh.store/webservice1.asmx/RegistrationPage?name="+n+"&email="+e+"&password="+p+"&mobile="+m;


// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                Toast.makeText(MainActivity.this,""+response,Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,""+error.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
                requestQueue.add(stringRequest);

// Add the request to the RequestQueue.
            }




        });
    }
}