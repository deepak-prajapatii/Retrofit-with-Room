package com.riseinsteps.retrofitwithroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface RoomDao {
    @Insert
    void insert(Model model);

    @Query("SELECT * FROM my_table")
    Model getModel();
}
