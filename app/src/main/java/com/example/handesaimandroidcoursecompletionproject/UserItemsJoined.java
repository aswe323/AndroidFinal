package com.example.handesaimandroidcoursecompletionproject;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"userName","itemID"})
public class UserItemsJoined {
    @NonNull
    public String userName;
    @NonNull
    public String itemID;



}
