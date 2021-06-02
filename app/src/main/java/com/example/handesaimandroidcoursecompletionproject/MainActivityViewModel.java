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
        usersWithItems = repository.getUsersWithItems();
    }
    public boolean authenticate(String userName, String id) {
        for (UserWithItems user :
                usersWithItems.getValue()) {
            if(user.user.getUserName().equals(userName) && user.user.getId().equals(id))
                if(repository.setLoggedUser(user)) {
                    return true;
                }
            return false;
        }
        return false;
    }

}
