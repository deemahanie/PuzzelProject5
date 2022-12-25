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
public interface DaoQuastion {
    @Insert
    void insertquastion(Quastion quastion);


    @Update
    void updatequastion(Quastion quastion);
    @Delete
    void  deletquastion(Quastion quastion);
    @Query("select * from Quastion where level_no = :level_no & pattern_id = :pattern_id")
    LiveData<List<Quastion>> getallquastion(int level_no , int pattern_id);
    @Query("select * from Quastion where pattern_id = :pattern_id")
    LiveData<List<Quastion>> getallquastion( int pattern_id);
    @Query("select * from Quastion")
    LiveData<List<Quastion>>getallquastion();

}
