package com.android.clinic.doctor_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.clinic.R;
import com.android.clinic.database.DatabaseHelperMethods;
import com.android.clinic.model.KeyValues;

public class FillPatientCardActivity extends AppCompatActivity {

    TextView fioPatient;
    TextView timeVisit;
    TextView diagnosis;
    EditText enterNote;
    Button sendButton;
    ImageView addDiagnosis;
    DatabaseHelperMethods myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_patient_card);

        fioPatient = (TextView) findViewById(R.id.fio_patient_View);
        timeVisit = (TextView) findViewById(R.id.time_visit_View);
        diagnosis = (TextView) findViewById(R.id.diagnosis_View);
        enterNote = (EditText) findViewById(R.id.note_doctor_EditText);
        sendButton = (Button) findViewById(R.id.send_diagnosis_button);
        addDiagnosis = (ImageView) findViewById(R.id.image_add_diagnosis);
        myDb = new DatabaseHelperMethods(this);

        fioPatient.setText(myDb.getFnamePatient(KeyValues.sIdTicket));
        timeVisit.setText(myDb.getTimeVisit(KeyValues.sIdTicket));
        diagnosis.setText(KeyValues.sDiagnosisName);
        addDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyValues.sDiagnosisName = "";
                Intent intent = new Intent(FillPatientCardActivity.this, DiagnosisActivity.class);
                startActivity(intent);
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSendSuccessful = myDb.setDataToCard(KeyValues.sIdTicket, KeyValues.sDiagnosisId, enterNote.getText().toString());
                if (isSendSuccessful) {
                    myDb.updateDataTicketFinal(Long.parseLong(KeyValues.sIdTicket));
                    Intent intent = new Intent(FillPatientCardActivity.this, MenuDoctorsActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FillPatientCardActivity.this, SignToDoctorsActivity.class);
        startActivity(intent);
    }
}
