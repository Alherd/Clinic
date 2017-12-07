package com.android.clinic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class ChooseActionActivity extends AppCompatActivity {
    private ImageView scheduleImageButton;
    private ImageView signUpDoctorImBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_action);
        scheduleImageButton = (ImageView) findViewById(R.id.photo_image_view_1);
        scheduleImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChooseActionActivity.this, DatabaseServiceSignUpActivity.class);
                startActivity(intent1);
            }
        });

        signUpDoctorImBut = (ImageView) findViewById(R.id.photo_image_view_2);
        signUpDoctorImBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActionActivity.this, DatabaseDoctorsSignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
