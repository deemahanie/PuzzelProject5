package com.example.puzzelproject;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


public class MyRepositry {
    private MyDaolLevel myDaolLevel;
    private  DaoQuastion daoQuastion;
    private  DaoPattern daoPattern;

    public MyRepositry(Application application) {
        MyRoomDatabase db = MyRoomDatabase.getDatabase(application);
         myDaolLevel = db.myDaolLevel();
       daoQuastion = db.daoQuastion();
       daoPattern = db.daoPattern();
    }
    void  insertlevel(levelData levelData){
      MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
          @Override
          public void run() {
              myDaolLevel.insertlevel(levelData);

          }
      });
    }

    void  updateleel(levelData levelData){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                myDaolLevel.updateleel(levelData);
            }
        });

    }

    void deletelevel(levelData levelData){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                myDaolLevel.deletelevel(levelData);
            }
        });

    }

    LiveData<List<levelData>> getlevelbyid(int id){
return myDaolLevel.getlevelbyid(id);
    }

    void insertquastion(Quastion quastion){
     MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
         @Override
         public void run() {
             daoQuastion.insertquastion(quastion);
         }
     });
    }
    void insertquastion1(Quastion quastion){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoQuastion.insertquastion(quastion);
            }
        });
    }

    void updatequastion(Quastion quastion){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoQuastion.updatequastion(quastion);
            }
        });
    }

    void  deletquastion(Quastion quastion){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoQuastion.deletquastion(quastion);
            }
        });
    }

    LiveData<List<Quastion>> getallquastion(int level_no , int pattern_id){
        return daoQuastion.getallquastion(level_no,pattern_id);
    }

    void insertpattern(pattern pattern){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
               daoPattern.insertpattern(pattern);
            }
        });

    }

    void updatepattern(pattern pattern){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoPattern.updatepattern(pattern);
            }
        });

    }

    void deletepattern(pattern pattern){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoPattern.deletepattern(pattern);
            }
        });

    }

    LiveData<List<pattern>> gatallpattern(int pattern_id){
        return daoPattern.gatallpattern(pattern_id);
    }

}
