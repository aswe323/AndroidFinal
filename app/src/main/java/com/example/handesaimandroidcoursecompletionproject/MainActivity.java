package com.example.handesaimandroidcoursecompletionproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mainActivityViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MainActivityViewModel.class);

    }

    public void authenticaateButtonMethod(View view){
        String id =(((EditText) view.getRootView().findViewById(R.id.stundentId)).getText().toString());
        String studentName =(((EditText) view.getRootView().findViewById(R.id.studentName)).getText().toString());
        Intent intent = new Intent(MainActivity.this,store.class);
        if(mainActivityViewModel.authenticate(studentName,id)) startActivity(intent);
    }


}