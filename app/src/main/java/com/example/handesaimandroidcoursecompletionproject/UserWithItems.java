package com.example.handesaimandroidcoursecompletionproject;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UserWithItems {
    @Embedded public UserItemsJoined userItemsJoined;
    @Relation(
            parentColumn = "userName",
            entityColumn = "itemID",
            associateBy = @Junction(UserItemsJoined.class)
    )
    //This is will not scale optimally
    public List<Item> shoppingList;

}

