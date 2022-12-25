package com.example.puzzelproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.puzzelproject.databinding.ActivitySettingBinding;
import com.example.puzzelproject.databinding.ActivityStartplayBinding;

import java.util.ArrayList;

public class StartPlay extends AppCompatActivity implements OnClick {
    ActivityStartplayBinding binding;
    ArrayList<datastartplay> datastartplayArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityStartplayBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Intent intent = getIntent();
//        intent.getIntExtra("id",-1);
//        intent.getIntExtra("unlock_points",1);
    
        datastartplayArrayList.add(new datastartplay("level1","level2"));
        AdapterStartPlay adapterStartPlay = new AdapterStartPlay(datastartplayArrayList,this);
       binding.rc.setAdapter(adapterStartPlay);
        RecyclerView.LayoutManager LM=new LinearLayoutManager(StartPlay.this,RecyclerView.VERTICAL,false);
        binding.rc.setLayoutManager(LM);

    }

    @Override
    public void onclick(int position) {
        startActivity(new Intent(getBaseContext(),Level.class));
    }
}