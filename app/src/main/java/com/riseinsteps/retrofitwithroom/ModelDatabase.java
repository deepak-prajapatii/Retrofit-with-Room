package com.riseinsteps.retrofitwithroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Model.class, version = 1, exportSchema = false)
public abstract class ModelDatabase extends RoomDatabase {
    private static ModelDatabase instance;

    public abstract RoomDao roomDao();


    public static synchronized ModelDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, ModelDatabase.class, "room_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
