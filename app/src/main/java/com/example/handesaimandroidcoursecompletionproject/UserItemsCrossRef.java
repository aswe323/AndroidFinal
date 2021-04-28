package com.example.handesaimandroidcoursecompletionproject;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"userName","itemID"},tableName = "UserItemsCrossRef")
public class UserItemsCrossRef {
    @NonNull
    public String userName;
    @NonNull
    public String itemID;
}
