package com.example.handesaimandroidcoursecompletionproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User... userDetails);

    @Query("SELECT * FROM Users")
    LiveData<List<User>> getAll();

    @Update
    void update(User... Users);

    @Transaction
    @Query("SELECT * FROM Users")
    public List<UserWithItems> getPlaylistsWithSongs();
    //Delete is Redundant for the project

}
