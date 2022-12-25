package com.example.puzzelproject;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {levelData.class,Quastion.class,pattern.class},version = 1,exportSchema = false)
public abstract class MyRoomDatabase extends RoomDatabase {

    public abstract MyDaolLevel myDaolLevel();
    public abstract DaoQuastion daoQuastion();
    public abstract DaoPattern daoPattern();

    private static volatile MyRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MyRoomDatabase  getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
              MyDaolLevel myDaolLevel  = INSTANCE.myDaolLevel();
               DaoQuastion daoQuastion = INSTANCE.daoQuastion();
               DaoPattern daoPattern = INSTANCE.daoPattern();
                // dao.delete(new Player());


            });
        }
    };
}
