package com.example.puzzelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.puzzelproject.databinding.SplashBinding;


public class Splash extends AppCompatActivity {
SplashBinding binding;
 Animation splashtop ,splapbottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = SplashBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        splashtop = AnimationUtils.loadAnimation(this,R.anim.splash_animationtop);
        splapbottom = AnimationUtils.loadAnimation(this,R.anim.splash_animationbottom);
        binding.puzzelImage.setAnimation(splashtop);
        binding.puzzelTv.setAnimation(splapbottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,Home.class);
                startActivity(intent);
                finish();

            }
        },2000);

    }
}