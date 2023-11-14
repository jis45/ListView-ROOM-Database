package com.atees.listroom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Datawords {

    @Insert
     void insert(Words words);
    @Update
    void update(Words words);
    @Delete
    void delete(Words words);

    @Query("DELETE From DataTable")
    void deleteAllwords();

    @Query("SELECT * From DataTable")
    LiveData<List<Words>> getAllwords();
}
