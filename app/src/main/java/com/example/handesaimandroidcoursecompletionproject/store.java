package com.example.handesaimandroidcoursecompletionproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class store extends AppCompatActivity {


    //At this point we already know there is value in the livedata, however, this is not secured from a lifecycle perspective.
    LiveData<List<UserWithItems>> usersWithItems = Repository.getInstance(getApplication()).getUsersWithItems();

    List<Item> userItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_store2);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);





//        recyclerView.setAdapter();
    }
}