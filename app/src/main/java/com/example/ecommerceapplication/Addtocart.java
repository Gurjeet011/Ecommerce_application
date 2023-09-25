package com.example.ecommerceapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Addtocart extends Fragment {


    int pos;
    public Addtocart(int pos) {
        // Required empty public constructor
        this.pos = pos;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addtocart, container, false);


      return   view;

    }
}