package com.myfirstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    EditText etfirst_name, etlast_name, etemail, etpassword, etconfirm_password, etlocation;
    Button bregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        preferences = getSharedPreferences(Constants.STORAGE, MODE_PRIVATE);
        editor = preferences.edit();

        init();
    }

    private void init() {
        etfirst_name = findViewById(R.id.etfirst_name);
        etlast_name = findViewById(R.id.etlast_name);
        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etPassword);
        etconfirm_password = findViewById(R.id.etconfirm_password);
        etlocation = findViewById(R.id.etlocation);
        bregister=findViewById(R.id.bregister);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final String first_name = etfirst_name.getText().toString();
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (etfirst_name.getText().toString().trim().isEmpty()) {
                    Toast.makeText(signup.this, "please fill the first name", Toast.LENGTH_SHORT).show();
                } else if (etlast_name.getText().toString().trim().isEmpty()) {
                    Toast.makeText(signup.this, "please fill the last name", Toast.LENGTH_SHORT).show();
                } else if (etemail.getText().toString().trim().isEmpty()) {
                    Toast.makeText(signup.this, "please fill the email address", Toast.LENGTH_SHORT).show();
                } else if (etpassword.getText().toString().trim().isEmpty()) {
                    Toast.makeText(signup.this, "please fill the password", Toast.LENGTH_SHORT).show();
                } else if (etconfirm_password.getText().toString().trim().isEmpty()) {
                    Toast.makeText(signup.this, "please fill the confirm password address", Toast.LENGTH_SHORT).show();
                } else if (etlocation.getText().toString().trim().isEmpty()) {
                    Toast.makeText(signup.this, "please fill the location", Toast.LENGTH_SHORT).show();
                } else if (!etpassword.getText().toString().equals(etconfirm_password.getText().toString())) {
                    Toast.makeText(signup.this, "Passwords doesn't match", Toast.LENGTH_SHORT).show();
                }

                else{
                    editor.putString("fname", etfirst_name.getText().toString().trim());
                    editor.putString("lname", etlast_name.getText().toString().trim());
                    editor.putString("email", etemail.getText().toString().trim());
                    editor.putString("password", etpassword.getText().toString().trim());
                    editor.putString("location", etlocation.getText().toString().trim());
                    editor.commit();

                    Intent intentobj = new Intent(signup.this, Home.class);
                    startActivity(intentobj);
                }

            }
        });
    }
}