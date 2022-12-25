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
public interface DaoPattern {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   void insertpattern( pattern pattern) ;
    @Update
    void updatepattern(pattern pattern);
    @Delete
    void deletepattern(pattern pattern);

    @Query("select * from pattern where pattern_id = :pattern_id ")
    LiveData<List<pattern>> gatallpattern(int pattern_id);
}
