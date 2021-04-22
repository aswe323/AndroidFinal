package com.example.handesaimandroidcoursecompletionproject;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;

import java.util.List;

public class Repository {
    public UserDao userDao;
    public ItemDao itemDao;
    private LiveData<List<User>> userList;
    private LiveData<List<Item>> itemList;
    private boolean flag = false;
    private Repository repository;

    Repository(Application application) {
        this.flag = true;
        DataBase database = DataBase.getDatabase(application);
        this.userDao = database.UserDao();
        this.itemDao = database.ItemDao();
        this.userList = userDao.getAll();
        this.itemList = itemDao.getAll();
        userDao.insert(new User("Matan", "123456789",0));
        userDao.insert(new User("John Doe", "987654321",0));
        userDao.insert(new User("Rosa Park", "4206950053",0));
        userDao.insert(new User("leeroy Jerkins", "123456789",0));
        userDao.insert(new User("Oni-Chan", "Yamete",0));
        itemDao.insert(new Item("001","Milk",10));
        itemDao.insert(new Item("002","cookies",5));
        itemDao.insert(new Item("003","pasta",20));
        itemDao.insert(new Item("004","coco powder",18));
        itemDao.insert(new Item("005","pita",7));
    }

    public Repository getInstance(Application application){
        if(flag) return repository;
        repository = new Repository(application);
        return repository;
    }

    public boolean authenticate(String userName, String id){
        for (User user : userList.getValue() ) {
            if(user.getUserName().equals(userName) && user.getId().equals(id))
                return true;
            }
        return false;
        }

    public LiveData<List<User>> getUserList() {
        return userList;
    }

    public LiveData<List<Item>> getItemList() {
        return itemList;
    }


}
