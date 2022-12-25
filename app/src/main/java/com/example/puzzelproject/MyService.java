package com.example.puzzelproject;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.Manifest;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.SyncStateContract;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class MyService extends Service {
    MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.START_FOREGROUND_SERVICES_FROM_BACKGROUND)
//                != PackageManager.PERMISSION_GRANTED
//        ){
//            intent = new Intent(getBaseContext(),MyService.class);
//            startForegroundService(intent);
//
//        } else if (intent.getAction().equals( SyncStateContract.Constants.ACCOUNT_NAME.STOPFOREGROUND_ACTION)) {
//            Log.i("LOG_TAG", "Received Stop Foreground Intent");
//            //your end servce code
//            stopForeground(true);
//            stopSelfResult(startId);
//        }
//        if (intent.getAction() != null){
//
//            if (intent.getAction().equals("stop")){
//                stopSelf();
//            }}
//        mediaPlayer.start();
//        return START_STICKY;
//        if (intent.getAction().equals(SyncStateContract.Constants.ACTION.STARTFOREGROUND_ACTION
//            )) {
//            Log.i("LOG_TAG", "Received Start Foreground Intent ");
//            // your start service code
//        } else if (Objects.equals(intent.getAction(), SyncStateContract.Constants.ACTION.STOPFOREGROUND_ACTION)) {
//            Log.i("LOG_TAG", "Received Stop Foreground Intent");
//            //your end servce code
//            stopForeground(true);
//            stopSelfResult(startId);
//        }
//        return START_STICKY;
//    }
        intent = new Intent(getBaseContext(),MyService.class);
           startService(intent);
        mediaPlayer.start();
        return START_STICKY;
}

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}