package com.android.clinic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.clinic.database.DatabaseHelper;

public class DatabaseCardPatientsActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_card_patients);
        header = (TextView) findViewById(R.id.header_map);
        userList = (ListView) findViewById(R.id.list_map);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = mDatabaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select _id_card as _id, * from " + DatabaseHelper.TABLE_MEDICAL_CARD_PATIENTS + ", "
                + DatabaseHelper.TABLE_SIGN_UP_PATIENTS + ", " + DatabaseHelper.TABLE_DIAGNOSIS_PATIENTS + ", "
                + DatabaseHelper.TABLE_DOCTORS
                + ", " + DatabaseHelper.TABLE_SCHEDULE_DOCTORS + " where "
                + DatabaseHelper.COLUMN_SIGN_ID_CARD + " == " + DatabaseHelper.COLUMN_SIGN_UP_ID
                + " AND " + DatabaseHelper.COLUMN_DIAGNOSIS_COD_CARD + " == " + DatabaseHelper.COLUMN_ID_DIAGNOSIS
                + " AND " + DatabaseHelper.COLUMN_SIGN_UP_ID_TICKET + " == " + DatabaseHelper.COLUMN_SCHEDULE_ID
                + " AND " + DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_ID + " == " + DatabaseHelper.COLUMN_ID_DOCTOR
                + " AND " + DatabaseHelper.COLUMN_SIGN_UP_ID_PATIENTS + " == '" + KeyValues.sIdPatient
                + "' ;", null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_NAME_DOCTOR, DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_DATETIME,
                DatabaseHelper.COLUMN_NAME_DIAGNOSIS, DatabaseHelper.COLUMN_NOTE_DOCTOR_CARD};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, R.layout.five_line_list_card,
                userCursor, headers1, new int[]{R.id.text2_1, R.id.text3_1, R.id.text4_1, R.id.text5_1}, 0);
        header.setText("Ваша медкарта");
        userList.setAdapter(userAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}