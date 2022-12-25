package com.example.puzzelproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;

import com.example.puzzelproject.databinding.ActivityHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public class Home extends AppCompatActivity {
     ActivityHomeBinding  binding;
    MediaPlayer mediaPlayer;
    boolean isplaying = false;
    Intent intent;

    int idlevel;
    int unlock_points;
    int pattern_id;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
      setContentView(binding.getRoot());
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
     String jsonString = UtilyString.readfromasets(getApplicationContext(),"puzzleGameData.json");
//      parsejsonstring(jsonString);
//      myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        parsejsonstring1(jsonString);
        parsejsonstring(jsonString);

//        Log.d("readfromfile", jsonString);

//        if (!isplaying ) {
//            intent = new Intent(getBaseContext(), MyService.class);
//            startForegroundService(intent);
//            isplaying = true;
//        }else {
//            stopService(intent);
//
//            isplaying = false;
//
//        }

//         intent = new Intent(getBaseContext(),MyService.class);
//        startService(intent);
//        Intent startIntent = new Intent(Home.this, MyService.class);
//        startIntent.setAction(SyncStateContract.Constants.ACTION.STARTFOREGROUND_ACTION);
//        startService(startIntent);
//
//        Intent stopIntent = new Intent(Home.this, MyService.class);
//        stopIntent.setAction(SyncStateContract.Constants.ACTION.STOPFOREGROUND_ACTION);
//        startService(stopIntent);


        binding.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),Setting.class));

            }
        });
        binding.btnStartplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getBaseContext(), StartPlay.class);
//               intent.putExtra("id",String.valueOf(idlevel));
//               intent.putExtra("unlock_points",String.valueOf(unlock_points));
                startActivity(intent);

            }
        });

    }

    private void parsejsonstring1(String jsonString) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
//                ArrayList<Quastion> quastionArrayList = new ArrayList<>();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                idlevel = jsonObject.getInt("level_no");
                unlock_points = jsonObject.getInt("unlock_points");
                Log.d("jsonobject", jsonObject.toString());
                myViewModel.insertlevel(new levelData(unlock_points));
                JSONArray jsonArray1 = jsonObject.getJSONArray("questions");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    JSONObject jsonObjectquastin = jsonArray1.getJSONObject(i);
//                    myViewModel.insertquastion(idlevel, pattern_id);
                    JSONArray patternjsonarray = jsonObjectquastin.getJSONArray("pattern");
                    for (int k = 0; k < patternjsonarray.length(); k++) {
                        JSONObject jsonObject1 = patternjsonarray.getJSONObject(j);
                        pattern_id = jsonObject1.getInt("pattern_id");
                        String pattern_name = jsonObject1.getString("pattern_name");
                        Log.d("pattern", patternjsonarray.toString());
                        myViewModel.insertpattern(new pattern(pattern_name));


                    }

                }
            }


            } catch (JSONException e) {
            e.printStackTrace();



        }
        }
    private void parsejsonstring(String jsonString) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
//                ArrayList<Quastion> quastionArrayList = new ArrayList<>();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
////                idlevel = jsonObject.getInt("level_no");
////                unlock_points = jsonObject.getInt("unlock_points");
////                myViewModel.insertlevel(new levelData(unlock_points));
                JSONArray jsonArray1 = jsonObject.getJSONArray("questions");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    JSONObject jsonObjectquastin =  jsonArray1.getJSONObject(i);
                    int id = jsonObjectquastin.getInt("id");
                    String title = jsonObjectquastin.getString("title");
                    String answer_1 = jsonObjectquastin.getString("answer_1");
                    String answer_2 = jsonObjectquastin.getString("answer_2");
                    String answer_3 = jsonObjectquastin.getString("answer_3");
                    String answer_4 = jsonObjectquastin.getString("answer_4");
                    String trueanswer = jsonObjectquastin.getString("true_answer");
                    int points = jsonObjectquastin.getInt("points");
                    int  duration =  jsonObjectquastin.getInt("duration");
                    String  hint = jsonObjectquastin.getString("hint");
                    Log.d(
                            "quastion ", jsonObjectquastin.toString());
                    myViewModel.insertquastion(new Quastion(title,answer_1,answer_2,answer_3,answer_4,trueanswer,points,duration,hint,pattern_id,idlevel));

//                    JSONArray patternjsonarray = jsonObjectquastin.getJSONArray("pattern");
//                    for (int k = 0; k < patternjsonarray.length(); k++) {
//                        JSONObject jsonObject1 = patternjsonarray.getJSONObject(j);
//                        pattern_id = jsonObject1.getInt("pattern_id");
//                        String pattern_name = jsonObject1.getString("pattern_name");
//                        myViewModel.insertpattern(new pattern(pattern_name));


                    }

                }



        } catch (JSONException e) {
            e.printStackTrace();



        }
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent = new Intent(getBaseContext(),MyService.class);
        stopService(intent);
    }

}