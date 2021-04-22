package com.example.handesaimandroidcoursecompletionproject;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    private String userName;
    @ColumnInfo(name = "User id")
    private String id;
    @ColumnInfo(name = "User Price Total")
    private int priceTotal;

    public User(@NonNull String userName, String id, int priceTotal) {
        this.userName = userName;
        this.id = id;
        this.priceTotal = priceTotal;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getUserName() {
        return userName;
    }

    public String getId() {
        return id;
    }

    public int getPriceTotal() {
        return priceTotal;
    }


}
