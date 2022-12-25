package com.example.puzzelproject;

import androidx.room.TypeConverter;

import java.util.Date;

public class Dateconvert {
    @TypeConverter
    public  long toDate(Date date){
       return date.getTime();
    }
    @TypeConverter
    public Date toDate(Long date){
        return new Date(date);
    }
}
