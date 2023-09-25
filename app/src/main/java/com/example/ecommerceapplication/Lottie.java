package com.example.ecommerceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class Lottie extends AppCompatActivity {
LottieAnimationView lottieAnimationView;
    private static final int SPLASH_DURATION = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        lottieAnimationView = findViewById(R.id.lottie);
        lottieAnimationView.setAnimation(R.raw.lottie);
        lottieAnimationView.playAnimation();
        lottieAnimationView.loop(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Lottie.this,Homepage.class));
                finish();
            }
        }, SPLASH_DURATION);
    }
}
