package com.example.handesaimandroidcoursecompletionproject;

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

    //Todo: implament Shopping List functionality into the DB
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Update
    void update(User... userDetails);

    @Transaction
    @Query("SELECT * FROM User")
    public List<UserWithItems> getPlaylistsWithSongs();
    //Delete is Redundant for the project

}
