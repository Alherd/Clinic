package com.android.clinic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.UUID;

import static com.android.clinic.DatabaseServiceActivity.arg;

public class DescriptionDoctorsActivity extends AppCompatActivity {
    TextView nameDoctors;
    private static final String EXTRA_DOCTOR_ID =
            "com.android.clinic.doctor_id";

    public static Intent newIntent(Context packageContext, long doctorId) {
        Intent intent = new Intent(packageContext, DescriptionDoctorsActivity.class);
        intent.putExtra(EXTRA_DOCTOR_ID, doctorId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_doctors);

        nameDoctors = (TextView) findViewById(R.id.nameDoctors);
        nameDoctors.setText(arg);
    }
}
