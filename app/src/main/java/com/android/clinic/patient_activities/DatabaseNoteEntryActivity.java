package com.android.clinic.patient_activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.clinic.model.KeyValues;
import com.android.clinic.R;
import com.android.clinic.database.DatabaseHelper;
import com.android.clinic.database.DatabaseHelperMethods;

import static com.android.clinic.database.DatabaseHelper.COLUMN_ID_DOCTOR;
import static com.android.clinic.database.DatabaseHelper.COLUMN_NAME_DOCTOR;
import static com.android.clinic.database.DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_DATETIME;
import static com.android.clinic.database.DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_ID;
import static com.android.clinic.database.DatabaseHelper.COLUMN_SCHEDULE_ID;
import static com.android.clinic.database.DatabaseHelper.COLUMN_SIGN_UP_ID_TICKET;

public class DatabaseNoteEntryActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    DatabaseHelperMethods myDb;
    AlertDialog.Builder ad;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_note_entry);
        header = (TextView) findViewById(R.id.header_note);
        userList = (ListView) findViewById(R.id.list_note);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
        myDb = new DatabaseHelperMethods(getApplicationContext());
        myDb = new DatabaseHelperMethods(this);
        context = DatabaseNoteEntryActivity.this;
    }

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = mDatabaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select _id_sign_up as _id, * from " + DatabaseHelper.TABLE_SIGN_UP_PATIENTS + ", "
                + DatabaseHelper.TABLE_SCHEDULE_DOCTORS + ", "
                + DatabaseHelper.TABLE_DOCTORS + " where " + DatabaseHelper.COLUMN_SIGN_UP_ID_PATIENTS
                + " == '" + KeyValues.sIdPatient + "' AND " + COLUMN_SIGN_UP_ID_TICKET + " == " + COLUMN_SCHEDULE_ID + " AND "
                + COLUMN_SCHEDULE_DOCTORS_ID + " == " + COLUMN_ID_DOCTOR + " order by " +
                DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_DATETIME + " ;", null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers = new String[]{COLUMN_SCHEDULE_DOCTORS_DATETIME, COLUMN_NAME_DOCTOR};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, R.layout.two_line_button_list_item,
                userCursor, headers, new int[]{R.id.text1, R.id.text2}, 0);
        header.setText("Мои талоны");
        userList.setAdapter(userAdapter);

        userList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
                String title = myDb.getDateTimeSign(id);
                String message = "Удалить талон?";
                String button1String = "нет";
                String button2String = "да";

                ad = new AlertDialog.Builder(context);
                ad.setTitle(title);
                ad.setMessage(message);
                ad.setPositiveButton(button2String, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        myDb.updateDataTicketPatientsOn(id);
                        myDb.removeDataPatientTicket(KeyValues.sIdPatient, id);
                        Toast.makeText(DatabaseNoteEntryActivity.this, "Талон удален", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DatabaseNoteEntryActivity.this, MenuActivity.class);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}
