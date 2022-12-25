package com.example.puzzelproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    MyRepositry myRepositry;
    public MyViewModel(@NonNull Application application) {
        super(application);
        myRepositry = new MyRepositry(application);
    }
    void  insertlevel(levelData levelData){
      myRepositry.insertlevel(levelData);}

    void  updateleel(levelData levelData){
       myRepositry.updateleel(levelData);
    }

    void deletelevel(levelData levelData){
        myRepositry.deletelevel(levelData);
    }

    LiveData<List<levelData>> getlevelbyid(int id){
        return myRepositry.getlevelbyid(id);
    }

    void insertquastion(Quastion quastion){
       myRepositry.insertquastion(quastion);
    }

    void updatequastion(Quastion quastion){
       myRepositry.updatequastion(quastion);
    }

    void  deletquastion(Quastion quastion){
       myRepositry.deletquastion(quastion);
    }

    LiveData<List<Quastion>> getallquastion(int level_no , int pattern_id){
        return myRepositry.getallquastion(level_no,pattern_id);
    }

    void insertpattern(pattern pattern){
       myRepositry.insertpattern(pattern);

    }

    void updatepattern(pattern pattern){
       myRepositry.updatepattern(pattern);

    }

    void deletepattern(pattern pattern){
        myRepositry.deletepattern(pattern);

    }

    LiveData<List<pattern>> gatallpattern(int pattern_id){
        return myRepositry.gatallpattern(pattern_id);
    }


}
