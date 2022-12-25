package com.example.puzzelproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.puzzelproject.databinding.ActivitySettingBinding;

public class Setting extends AppCompatActivity {
ActivitySettingBinding binding;
 boolean isplaying = false;
    Intent intent;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.btnStopandstartsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (!isplaying){
                 intent = new Intent(getBaseContext(),MyService.class);
                 startService(intent);
             }else {
                 intent = new Intent(getBaseContext(),MyService.class);
                 stopService(intent);
             }

            }});}}
//                mediaPlayer = MediaPlayer.create(Setting.this, R.raw.music);

//                if (!isplaying ) {
//                    intent = new Intent(getBaseContext(), MyService.class);
//                    startForegroundService(intent);
//
//                }else {
//                ContextCompat.startForegroundService(getBaseContext(), intent);    }
//                {
//                        isplaying = true;
//                    }
//                    stopService(intent);
//
//                    isplaying = false;
//
//                }




















