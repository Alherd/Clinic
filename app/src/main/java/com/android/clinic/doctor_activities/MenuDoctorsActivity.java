package com.android.clinic.doctor_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.clinic.R;

public class MenuDoctorsActivity extends AppCompatActivity {

    Button signToMe;
    Button shankTickets;
    Button resultDiagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_doctors);
        signToMe = (Button) findViewById(R.id.signUp);
        signToMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDoctorsActivity.this, SignToDoctorsActivity.class);
                startActivity(intent);
            }
        });

        shankTickets = (Button) findViewById(R.id.shankTickets);
        shankTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDoctorsActivity.this, TicketsToDoctorActivity.class);
                startActivity(intent);
            }
        });

        resultDiagnosis = (Button) findViewById(R.id.resultDiagnosis);
        resultDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDoctorsActivity.this, ResultDiagnosisActivity.class);
                startActivity(intent);
            }
        });
    }
}
