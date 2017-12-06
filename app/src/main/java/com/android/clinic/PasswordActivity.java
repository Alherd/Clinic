package com.android.clinic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.clinic.database.DatabaseHelperMethods;

public class PasswordActivity extends AppCompatActivity {
    DatabaseHelperMethods myDb;
    Button guest_button;
    Button registration_button;
    Button into_button;
    Button forgetData;
    EditText editLogin;
    EditText editPassword;

    public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        private class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;

            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }

            public char charAt(int index) {
                return '*'; // This is the important part
            }

            public int length() {
                return mSource.length(); // Return default
            }

            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end); // Return default
            }
        }
    }

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        myDb = new DatabaseHelperMethods(this);

        registration_button = (Button) findViewById(R.id.registration);
        into_button = (Button) findViewById(R.id.into);

        editLogin = (EditText) findViewById(R.id.login);
        editPassword = (EditText) findViewById(R.id.password);
        editPassword.setTransformationMethod(new AsteriskPasswordTransformationMethod());
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
                boolean check = myDb.searchLoginPassword(editLogin.getText().toString(), editPassword.getText().toString());
                if (check) {
                    Patients mPatient = new Patients();
                    mPatient.setPatientFNAME(myDb.returnPatientFName(editLogin.getText().toString()));
                    mPatient.setPatientID(myDb.returnPatientID(editLogin.getText().toString()));
                    mPatient.setSignUp(true);
                    KeyValues.sIdPatient = mPatient.getPatientID();
                    KeyValues.sIsSignUp = mPatient.isSignUp();
                    Toast.makeText(PasswordActivity.this, "Здравствуйте, " + mPatient.getPatientFNAME() +
                            "!", Toast.LENGTH_LONG).show();
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
                Patients mPatient = new Patients();
                mPatient.setSignUp(false);
                KeyValues.sIsSignUp = mPatient.isSignUp();
                //KeyValues.sIdPatient = null;
                Intent intent = new Intent(PasswordActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        forgetData = (Button) findViewById(R.id.if_forget_password);
        forgetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, GetPrivateDataActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        //openQuitDialog();
        Intent intent = new Intent(PasswordActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
