package com.myfirstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText etEmail,etPassword;
    Button bLogin,bCreate_new_account,bLogin_with_Google_account;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    CheckBox cbsave_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences(Constants.STORAGE, MODE_PRIVATE);
        editor=preferences.edit();
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        cbsave_info=findViewById(R.id.cbsave_info);
        bLogin=findViewById(R.id.bLogin);
        bCreate_new_account=findViewById(R.id.Create_new_account);
        bLogin_with_Google_account=findViewById(R.id.bLogin_with_Google_account);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etEmail.setHint(preferences.getString("email","abc"));
        etPassword.setHint(preferences.getString("password","abc"));

    bLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            final String email = etEmail.getText().toString();
            final String password = etPassword.getText().toString();
            if (preferences.getString("email","abc").equals(email) && preferences.getString("password","abc").equals(password))
            {
                Intent intent=new Intent(Login.this,Home.class);
                startActivity(intent);
                editor.putBoolean("login",cbsave_info.isChecked());
                editor.commit();
            }
            else
                Toast.makeText(Login.this,"email and pasword not found",Toast.LENGTH_SHORT).show();




             }
    });
        bCreate_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,signup.class);
                startActivity(intent);

            }

        });
        bLogin_with_Google_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this, google.class);
                startActivity(intent);
            }
        });
        if (preferences.getBoolean("login",false)){
            Intent intent=new Intent(Login.this,Home.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
