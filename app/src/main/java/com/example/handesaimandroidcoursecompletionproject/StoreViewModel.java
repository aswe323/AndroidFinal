package com.example.handesaimandroidcoursecompletionproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class StoreViewModel extends AndroidViewModel {

    Repository repository;
    String userName;
    String id;

    public StoreViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(getApplication());

    }
}
