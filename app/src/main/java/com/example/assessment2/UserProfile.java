package com.example.assessment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    TextView name, dob, gender, country, phone, email;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        name = findViewById(R.id.name);
        dob = findViewById(R.id.dob);
        gender = findViewById(R.id.gender);
        country = findViewById(R.id.country);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        image = findViewById(R.id.profileimagee);

        Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString("name"));
        dob.setText(bundle.getString("dob"));
        gender.setText(bundle.getString("gender"));
        country.setText(bundle.getString("country"));
        phone.setText(bundle.getString("phone"));
        email.setText(bundle.getString("email"));
        image.setImageResource(bundle.getInt("image"));
    }
}
