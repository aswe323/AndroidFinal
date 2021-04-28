package com.example.handesaimandroidcoursecompletionproject;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    private Repository repository;

    public MainActivityViewModel(Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }

    public boolean authenticate(String user, String id){
        return repository.authenticate(user,id);
    }


}
