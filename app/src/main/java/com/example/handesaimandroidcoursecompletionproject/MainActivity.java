package com.example.handesaimandroidcoursecompletionproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private Button authButton;


    final Observer<List<UserWithItems>> usersWithItemsObserver = new Observer<List<UserWithItems>>() {
        @Override
        public void onChanged(List<UserWithItems> observed) {
            if (observed != null) {
                authButton.setEnabled(true);
            }else{
                authButton.setEnabled(false);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mainActivityViewModel =  new ViewModelProvider(MainActivity.this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MainActivityViewModel.class);

        authButton = findViewById(R.id.autheniticateButton);
        mainActivityViewModel.getUsersWithItems().observe(this,usersWithItemsObserver);
    }

    public void authenticateButtonMethod(View view){
        String id =(((EditText) view.getRootView().findViewById(R.id.stundentId)).getText().toString());
        String studentName =(((EditText) view.getRootView().findViewById(R.id.studentName)).getText().toString());

        Intent intent = new Intent(MainActivity.this,store.class);
        intent.putExtra("studentName",studentName);
        intent.putExtra("id",id);
        if(mainActivityViewModel.authenticate(studentName,id))
            startActivity(intent);
    }


}