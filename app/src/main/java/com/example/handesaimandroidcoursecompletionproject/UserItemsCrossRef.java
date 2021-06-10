package com.example.handesaimandroidcoursecompletionproject;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"userName","itemID"},tableName = "UserItemsCrossRef")
public class UserItemsCrossRef {
    @NonNull
    public String userName;
    @NonNull
    public String itemID;

    @NonNull
    public int qty;

    // FIXME: 02/06/2021 : each field in items does no corresponds to a single user, creating multypale fields of the same propertys is bad use of resources
    // FIXME SOLUTION FOUND: 02/06/2021 : add a qty field to the reference table, and update the fields in the cross reference table. using the keys to access each item/user as needed. required a CrossRef table Dao.
}
