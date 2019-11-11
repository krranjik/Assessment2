package com.example.assessment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().setTitle("User Registration Form");
    }
}
