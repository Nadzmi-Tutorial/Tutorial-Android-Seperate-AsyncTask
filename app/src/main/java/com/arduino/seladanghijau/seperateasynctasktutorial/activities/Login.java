package com.arduino.seladanghijau.seperateasynctasktutorial.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arduino.seladanghijau.seperateasynctasktutorial.R;
import com.arduino.seladanghijau.seperateasynctasktutorial.asynctask.AsyncLogin;
import com.arduino.seladanghijau.seperateasynctasktutorial.interfaces.ILogin;

public class Login extends AppCompatActivity implements View.OnClickListener {
    // views
    EditText etUsername, etPassword;
    Button btnLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnLogin:
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                new AsyncLogin(
                        this,
                        username,
                        password,
                        new ILogin() {
                            public void processFinished(String result) {
                                Toast.makeText(Login.this, result, Toast.LENGTH_LONG).show();
                            }
                        }
                ).execute();
                break;
        }
    }
}
