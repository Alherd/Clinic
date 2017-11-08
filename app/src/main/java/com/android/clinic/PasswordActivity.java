package com.android.clinic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.clinic.database.DatabaseHelper;

public class PasswordActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button guest_button;
    Button registration_button;
    Button into_button;
    EditText editLogin;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        myDb = new DatabaseHelper(this);

        registration_button = (Button) findViewById(R.id.registration);
        into_button = (Button) findViewById(R.id.into);
        editLogin = (EditText) findViewById(R.id.login);
        editPassword = (EditText) findViewById(R.id.password);

        registration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        into_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = myDb.insearch(editLogin.getText().toString(), editPassword.getText().toString());
                if (check == true) {
                    Toast.makeText(PasswordActivity.this, "Вход выполнен", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(PasswordActivity.this, MenuActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(PasswordActivity.this, "Неверный логин или пароль", Toast.LENGTH_LONG).show();
            }
        });

        guest_button = (Button) findViewById(R.id.continue_button);
        guest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}