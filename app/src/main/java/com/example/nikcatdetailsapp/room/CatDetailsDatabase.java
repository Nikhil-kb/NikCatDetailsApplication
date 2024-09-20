package com.example.nikcatdetailsapp.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CatDetailsEntity.class}, version = 1)
public abstract class CatDetailsDatabase extends RoomDatabase {

    public abstract CatDetailsDao getCatDetailsDao();


    private static volatile CatDetailsDatabase catDetailsDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CatDetailsDatabase getDatabase(final Context context) {
        if (catDetailsDatabase == null) {
            synchronized (CatDetailsDatabase.class) {
                if (catDetailsDatabase == null) {
                    catDetailsDatabase = Room.databaseBuilder(context.getApplicationContext(),
                                    CatDetailsDatabase.class, "cat_database")
                                    .allowMainThreadQueries()
                                            .build();
                }
            }
        }
        return catDetailsDatabase;
    }

}
