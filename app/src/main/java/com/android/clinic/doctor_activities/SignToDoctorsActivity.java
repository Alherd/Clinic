package com.android.clinic.doctor_activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.clinic.R;
import com.android.clinic.database.DatabaseHelper;
import com.android.clinic.database.DatabaseHelperMethods;
import com.android.clinic.model.KeyValues;

import static com.android.clinic.database.DatabaseHelper.COLUMN_ID_PATIENT;
import static com.android.clinic.database.DatabaseHelper.COLUMN_SCHEDULE_ID;
import static com.android.clinic.database.DatabaseHelper.COLUMN_SCHEDULE_IS_ORDER;
import static com.android.clinic.database.DatabaseHelper.COLUMN_SIGN_UP_ID_PATIENTS;
import static com.android.clinic.database.DatabaseHelper.COLUMN_SIGN_UP_ID_TICKET;
import static com.android.clinic.database.DatabaseHelper.COLUMN_SIGN_UP_IS_OVER;

public class SignToDoctorsActivity extends AppCompatActivity {

    ListView userList;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    DatabaseHelperMethods myDb;
    Context context;
    AlertDialog.Builder ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_to_doctors);

        userList = (ListView) findViewById(R.id.list_1);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
        myDb = new DatabaseHelperMethods(this);
        context = SignToDoctorsActivity.this;
    }

    @Override
    public void onResume() {
        super.onResume();
        db = mDatabaseHelper.getReadableDatabase();
        userCursor = db.rawQuery("select _id_sign_up as _id, * from " + DatabaseHelper.TABLE_SCHEDULE_DOCTORS + ", " +
                DatabaseHelper.TABLE_SIGN_UP_PATIENTS + ", " + DatabaseHelper.TABLE_PATIENTS + " where " +
                DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_ID + " == '" + KeyValues.sIdDoctor
                + "' and " + COLUMN_SIGN_UP_ID_TICKET + " == " + COLUMN_SCHEDULE_ID +
                " and " + COLUMN_SIGN_UP_ID_PATIENTS + " == " + COLUMN_ID_PATIENT +
                " and " + COLUMN_SIGN_UP_IS_OVER + " == '0' order by " +
                DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_DATETIME + ";", null);
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_DATETIME, DatabaseHelper.COLUMN_LNAME};
        userAdapter = new SimpleCursorAdapter(this, R.layout.two_line_list_item,
                userCursor, headers1, new int[]{R.id.text1, R.id.text2}, 0);
        userList.setAdapter(userAdapter);

        userList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
                String title = myDb.getDateTimeSign(id);
                String message = "Опубликовать результаты?";
                String button1String = "нет";
                String button2String = "да";

                ad = new AlertDialog.Builder(context);
                ad.setTitle(title);
                ad.setMessage(message);
                ad.setPositiveButton(button2String, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        KeyValues.sIdTicket = Long.toString(id);
                        KeyValues.sDiagnosisName = "";
                        KeyValues.sDiagnosisId = "";
                        KeyValues.sIdPatient = myDb.getIdPatient(id);
                        Intent intent = new Intent(SignToDoctorsActivity.this, FillPatientCardActivity.class);
                        startActivity(intent);
                    }
                });
                ad.setNegativeButton(button1String, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                    }
                });
                ad.setCancelable(true);
                ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                    }
                });
                ad.show();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignToDoctorsActivity.this, MenuDoctorsActivity.class);
        startActivity(intent);
    }
}
