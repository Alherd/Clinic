package com.android.clinic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.clinic.database.DatabaseHelperMethods;

public class GetPrivateDataActivity extends AppCompatActivity {

    EditText numberPhoneEditText;
    Button getData;
    TextView loginTextView;
    TextView passwordTextView;
    DatabaseHelperMethods myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_private_data);
        myDb = new DatabaseHelperMethods(this);

        numberPhoneEditText = (EditText) findViewById(R.id.enter_phone_editText);
        loginTextView = (TextView) findViewById(R.id.yourLogin);
        passwordTextView = (TextView) findViewById(R.id.yourPassword);
        getData = (Button) findViewById(R.id.myDataButton);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = myDb.getLoginFromPhone(numberPhoneEditText.getText().toString());
                String password = myDb.getPasswordFromPhone(numberPhoneEditText.getText().toString());
                loginTextView.setText(login);
                passwordTextView.setText(password);
                if ((login.equals("")) || (password.equals(""))) {
                    Toast.makeText(GetPrivateDataActivity.this, "Неверно набран номер", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
