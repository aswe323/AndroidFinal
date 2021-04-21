package com.example.handesaimandroidcoursecompletionproject;

import android.app.Application;

import androidx.room.Database;

public class Repository {
    public UserDao userDao;
    public ItemDao itemDao;

    Repository(Application application) {
        DataBase database = DataBase.getDatabase(application);
        this.userDao = database.UserDao();
        this.itemDao = database.ItemDao();

    }
}
