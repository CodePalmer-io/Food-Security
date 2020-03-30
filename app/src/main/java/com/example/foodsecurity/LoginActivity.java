package com.example.foodsecurity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.AlreadyBoundException;

public class LoginActivity extends AppCompatActivity {

    private EditText USERNAME;
    private EditText PASSWORD;
    private Button LOGIN;

    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        USERNAME = (EditText)findViewById(R.id.et_userName);
        PASSWORD = (EditText)findViewById(R.id.et_passWord);
        LOGIN = (Button) findViewById(R.id.et_Login);

        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(USERNAME.getText().toString(), PASSWORD.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword)
    {
        if((userName == "Username" && userPassword == "Password"))
        {
            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
        } else {
            counter--;

            if(counter == 0)
            {
                AlertDialog.Builder Alert = new AlertDialog.Builder(this);
                Alert.setMessage("Too many incorrect attempts. Account have been locked");
                Alert.setTitle("Error Message...");
                Alert.create().show();
                LOGIN.setEnabled(false);

            }
        }
    }
}
