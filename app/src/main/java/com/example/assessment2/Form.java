package com.example.assessment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Form extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    EditText name, dob, phone, email, imgg;
    RadioGroup radioGroup;
    Spinner spin;
    Button btnsubmit, btnview;
    String name1, dob1, gender, country, phone1, email1, imgg1;
    Calendar calendar = Calendar.getInstance();
    String[] countries = {"<--Select Your Country-->", "Nepal", "India", "Pakistan", "China", "Bangladesh", "Bhutan", "Maldives", "Afganistan"};

    DatePickerDialog.OnDateSetListener mydatepicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            calendar.set(year, Calendar.YEAR);
            calendar.set(month, Calendar.MONTH);
            calendar.set(dayOfMonth, Calendar.DAY_OF_MONTH);
            String mydateFormat = "dd-MM-y";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mydateFormat, Locale.getDefault());
            dob.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().setTitle("User Registration Form");

        name = findViewById(R.id.name);
        dob = findViewById(R.id.dob);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        radioGroup = findViewById(R.id.rg);
        imgg = findViewById(R.id.img);
        btnsubmit = findViewById(R.id.btnsubmit);
        btnview = findViewById(R.id.btnview);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_values, countries);
        spin.setAdapter(adapter);
        radioGroup.setOnCheckedChangeListener(this);
        setSpinnerValue();
        btnsubmit.setOnClickListener(this);
        dob.setOnClickListener(this);
    }

    private void setSpinnerValue() {
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                country = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Form.this,
                        "Please select country",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        name1 = name.getText().toString();
        dob1 = dob.getText().toString();
        phone1 = phone.getText().toString();
        email1 = email.getText().toString();
        imgg1 = imgg.getText().toString();

        if (v.getId() == R.id.dob) {
            new DatePickerDialog(this, mydatepicker, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        }

        if (v.getId() == R.id.btnsubmit) {

        }

        if (v.getId() == R.id.btnview) {

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        if (i == R.id.rbmale) {
            gender = "Male";
        }
        if (i == R.id.rbfemale) {
            gender = "Female";
        }
        if (i == R.id.rbother) {
            gender = "Other";
        }
    }

    private boolean validate() {

        if (TextUtils.isEmpty(name1)) {
            name.setError("Enter Name");
            return false;
        }

        if (TextUtils.isEmpty(dob1)) {
            dob.setError("Enter Date of Birth");
            return false;
        }

        if (TextUtils.isEmpty(gender)) {
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(country)) {
            Toast.makeText(this, "Select Country", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!TextUtils.isDigitsOnly(phone1)) {
            phone.setError("Invalid Phone");
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
            email.setError("Invalid Email");
            return false;
        }

        if (TextUtils.isEmpty(imgg1)){
            imgg.setError("Enter Image");
            return false;
        }

        return true;
    }
}
