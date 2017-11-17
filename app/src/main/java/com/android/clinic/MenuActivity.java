package com.android.clinic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button signUp;
    Button service;
    Button special;
    Button aboutUs;
    Button contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        signUp = (Button) findViewById(R.id.zapis);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ChooseActionActivity.class);
                startActivity(i);
            }
        });

        service = (Button) findViewById(R.id.service);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, DatabaseServiceActivity.class);
                startActivity(i);
            }
        });
        special = (Button) findViewById(R.id.medicalMap);
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, DatabaseCardPatientsActivity.class);
                startActivity(i);
            }
        });
        aboutUs = (Button) findViewById(R.id.about_us);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://10gp.by/o-nas"));
//                startActivity(intent);
                Intent i = new Intent(MenuActivity.this, AboutClinicActivity.class);
                startActivity(i);

            }
        });
        contacts = (Button) findViewById(R.id.contacts);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ContactsClinicActivity.class);
                startActivity(i);
            }
        });
    }
}
