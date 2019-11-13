package com.example.assessment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.assessment2.Module.User;

import java.util.List;

public class ProfileList extends AppCompatActivity {

    RecyclerView rvprofilelist;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);

        rvprofilelist = findViewById(R.id.rvprofile);
        Intent intent1 = getIntent();
        users = (List<User>) intent1.getSerializableExtra("allprofiles");
        UserAdapter adapter = new UserAdapter(this, users);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvprofilelist.setLayoutManager(layoutManager);
        rvprofilelist.setAdapter(adapter);
    }
}
