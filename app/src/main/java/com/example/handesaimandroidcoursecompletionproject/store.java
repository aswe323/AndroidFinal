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
        Intent intent = getIntent();


        //these are unnecessary beyond this scope, hence aren't class members.
        String userName = intent.getStringExtra("userName");
        String id = intent.getStringExtra("id");


        //wished there was a more concise way to do this, but fml who cares...
        for (UserWithItems user :
                usersWithItems.getValue()) {
            if (user.user.getUserName() == userName) userItems = user.shoppingList;
        }




        recyclerView.setAdapter();
    }
}