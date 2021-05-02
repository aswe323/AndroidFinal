package com.example.handesaimandroidcoursecompletionproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Database;

import java.util.List;

public class Repository implements LifecycleOwner {
    public UserDao userDao;
    public ItemDao itemDao;

    private LiveData<List<User>> userList;
    private List<User> savedUserList;

    private MyDataBase database;
    private LiveData<List<Item>> itemList;

    static private boolean flag = false;
    static private Repository repository;

    private Repository(Application application) {
        this.flag = true;
        database = MyDataBase.getDatabase(application);
        database.insertUser("Matan", "123456789");
        database.insertUser("John Doe", "987654321");
        database.insertUser("Rosa Park", "4206950053");
        database.insertUser("leeroy Jerkins", "123456789");
        database.insertUser("Oni-Chan", "Yamete");
        database.insertItem("001","Milk",10);
        database.insertItem("002","cookies",5);
        database.insertItem("003","pasta",20);
        database.insertItem("004","coco powder",18);
        database.insertItem("005","pita",7);
        this.userDao = database.UserDao();
        this.itemDao = database.ItemDao();
        this.userList = userDao.getAll();
        this.itemList = itemDao.getAll();
    }

    static public Repository getInstance(Application application){
        if(flag) return repository;
        repository = new Repository(application);
        return repository;
    }

    public boolean authenticate(String userName, String id) {
        ///TODO: Connect me to {@Link MyDataBase} authentication method
        // make it thread based using the database
        boolean[] success = database.authenticate(userName,id);

        while(!success[0]);//the dumbest shit, I have ever written.

        return success[1];
    }

    public LiveData<List<User>> getUserList() {
        return userList;
    }

    public LiveData<List<Item>> getItemList() {
        return itemList;
    }


    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
