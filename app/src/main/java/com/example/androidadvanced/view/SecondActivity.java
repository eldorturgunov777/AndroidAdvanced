package com.example.androidadvanced.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidadvanced.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {
    Button button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
    }

    private void initViews() {
        EditText edit_name = findViewById(R.id.edit_name);
        EditText edit_email = findViewById(R.id.edit_email);
        EditText edit_password = findViewById(R.id.edit_password);
        EditText edit_passwordConfirm = findViewById(R.id.edit_passwordConfirm);
        button_register = findViewById(R.id.button_register);

        button_register.setOnClickListener(v -> {
            String name = edit_name.getText().toString();
            String email = edit_email.getText().toString();
            String password = edit_password.getText().toString();
            String pswConfirm = edit_passwordConfirm.getText().toString();
            saveEmail(name, email, password, pswConfirm);
            Toast.makeText(this, "Succes, save data", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    void saveEmail(String name, String email, String password, String confirm) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putString("confirm", confirm);
        editor.apply();
    }

//    String loadEmail() {
//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
//        String name = prefs.getString("name", "pdp@gmail.com");
//        String email = prefs.getString("email", "pdp@gmail.com");
//        String password = prefs.getString("password", "pdp@gmail.com");
//        String confirm = prefs.getString("confirm", "pdp@gmail.com");
//        return name;
//    }


}