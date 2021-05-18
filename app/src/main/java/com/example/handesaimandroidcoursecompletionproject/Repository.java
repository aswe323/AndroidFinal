package com.example.handesaimandroidcoursecompletionproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;


import java.util.List;

public class Repository implements LifecycleOwner {
    public UserDao userDao;
    public ItemDao itemDao;

    private LiveData<List<UserWithItems>> userWithItemsList;

    private MyDataBase database;

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
        userDao = database.UserDao();
        itemDao = database.ItemDao();
        userWithItemsList = userDao.getUsersWithItems();
        // FIXME: 10/05/2021 : Thread isn't done when @authenticate is being called
        // FIXME SOLUTION FOUND: 10/05/2021 : Use observer to enable and disable authentication.
        // FIXME: 10/05/2021 : observer already knows it's oberving a livedata object
        // FIXME SOLUTION FOUND: 10/05/2021 : remove the LiveData<...> from the declaration of the observer
    }

    static public Repository getInstance(Application application){
        if(flag) return repository;
        repository = new Repository(application);
        return repository;
    }



    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }

    public LiveData<List<UserWithItems>> getUsersWithItems() {
        return userWithItemsList;
    }
}
