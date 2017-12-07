package com.android.clinic.patient_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.clinic.model.KeyValues;
import com.android.clinic.model.Patients;
import com.android.clinic.R;
import com.android.clinic.database.DatabaseHelperMethods;

public class RegistrationActivity extends AppCompatActivity {
    DatabaseHelperMethods myDb;
    Button register_button;
    EditText login;
    EditText password;
    EditText fname;
    EditText lname;
    EditText pname;
    EditText phone;
    EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        myDb = new DatabaseHelperMethods(this);

        login = (EditText) findViewById(R.id.insert_login_editText);
        password = (EditText) findViewById(R.id.insert_password_editText);
        fname = (EditText) findViewById(R.id.insert_fname_editText);
        lname = (EditText) findViewById(R.id.insert_lname_editText);
        pname = (EditText) findViewById(R.id.insert_pname_editText);
        phone = (EditText) findViewById(R.id.insert_phone_editText);
        address = (EditText) findViewById(R.id.insert_address_editText);

        register_button = (Button) findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isInserted = myDb.insertData(login.getText().toString(),
                        password.getText().toString(), fname.getText().toString(),
                        lname.getText().toString(), pname.getText().toString(),
                        phone.getText().toString(), address.getText().toString());

                switch (isInserted) {
                    case 1:
                        Patients mPatient = new Patients();
                        mPatient.setSignUp(true);
                        KeyValues.sIsSignUp = mPatient.isSignUp();
                        Toast.makeText(RegistrationActivity.this, R.string.reg_success, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegistrationActivity.this, MenuActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(RegistrationActivity.this, R.string.login_exists, Toast.LENGTH_LONG).show();
                        break;
                    case -1:
                        Toast.makeText(RegistrationActivity.this, R.string.reg_error, Toast.LENGTH_LONG).show();
                        break;
                    case 0:
                        Toast.makeText(RegistrationActivity.this, R.string.empty_field, Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
