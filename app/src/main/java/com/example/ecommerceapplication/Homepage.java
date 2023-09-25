package com.example.ecommerceapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homepage extends AppCompatActivity {
    private  MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


       // getSupportFragmentManager().beginTransaction().add(R.i)
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home_fragment()).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();


                if (itemId == R.id.home) {

                     getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home_fragment()).addToBackStack(null).commit();
                    return true;
               } else if (itemId == R.id.category) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new category ()).addToBackStack(null).commit();

                    return true;
                } else if (itemId == R.id.notification) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new notification()).addToBackStack(null).commit();
                    return true;
               } else if (itemId == R.id.account) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new profile()).addToBackStack(null).commit();
                    return true;
                }

                return false;
            }
        });


}


}
