package com.example.puzzelproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDaolLevel {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void  insertlevel(levelData levelData);
    @Update
    void  updateleel(levelData levelData);
    @Delete
    void deletelevel(levelData levelData);
    @Query("select * from levelData where level_no = :id ")
    LiveData<List<levelData>> getlevelbyid(int id);

}
