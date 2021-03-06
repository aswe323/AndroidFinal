package com.example.handesaimandroidcoursecompletionproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao{
    //Create Read Update Delete C.R.U.D


    //Create
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Item... Items);

    //Read
    @Query("SELECT * FROM Items")
    LiveData<List<Item>> getAll();

    //Update (Redundant for the use case of the project)
    @Update
    void update(Item... Items);

    //Delete (Redundant for the use case of the project)
}
