package com.example.handesaimandroidcoursecompletionproject;

import android.app.Application;
import android.widget.Button;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<UserWithItems>> usersWithItems;


    public LiveData<List<UserWithItems>> getUsersWithItems() {
        return usersWithItems;
    }

    public MainActivityViewModel(Application application) {
        super(application);
        repository = Repository.getInstance(application);
        this.usersWithItems = repository.userDao.getUsersWithItems();
    }

    public boolean authenticate(String user, String id){
        return repository.authenticate(user,id);
    }


}
