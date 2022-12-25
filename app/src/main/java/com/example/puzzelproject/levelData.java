package com.example.puzzelproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class levelData {
    @PrimaryKey(autoGenerate = true)
    int level_no;
    int unlock_points;

    public levelData(int unlock_points) {
        this.unlock_points = unlock_points;
    }

    public int getLevel_no() {
        return level_no;
    }

    public void setLevel_no(int level_no) {
        this.level_no = level_no;
    }

    public int getUnlock_points() {
        return unlock_points;
    }

    public void setUnlock_points(int unlock_points) {
        this.unlock_points = unlock_points;
    }
}
