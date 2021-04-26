package com.example.handesaimandroidcoursecompletionproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    private Repository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }

    public boolean authenticate(String user, String id){
        return repository.authenticate(user,id);
    }


}
