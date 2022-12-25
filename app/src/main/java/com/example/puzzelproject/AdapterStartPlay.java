package com.example.puzzelproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.puzzelproject.databinding.ItemstartplayBinding;

import java.util.ArrayList;

public class AdapterStartPlay  extends RecyclerView.Adapter<AdapterStartPlay.ViewHolder> {
    ArrayList<datastartplay> datastartplayArrayList  ;
    OnClick onClick;
    public AdapterStartPlay(ArrayList<datastartplay> datastartplayArrayList,OnClick onClick) {
        this.datastartplayArrayList = datastartplayArrayList;
       this. onClick= onClick;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemstartplayBinding binding = ItemstartplayBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos = position;
        datastartplay datastartplay = datastartplayArrayList.get(pos);
         holder.level1.setText(datastartplay.getLevel1());
         holder.level2.setText(datastartplay.getLevel2());
         holder.level1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
            onClick.onclick(pos);
             }
         });
         holder.level2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onClick.onclick(pos);
             }
         });

    }

    @Override
    public int getItemCount() {
        return  datastartplayArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView level1,level2;

        public ViewHolder(@NonNull ItemstartplayBinding binding) {
            super(binding.getRoot());

            level1 = binding.tvLevel1;
            level2 = binding.tvLevel2;


        }
    }
}
