package com.android.clinic;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.clinic.database.DatabaseHelper;
import com.android.clinic.database.DatabaseHelperMethods;

public class DatabaseScheduleActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    DatabaseHelperMethods myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_schedule);

        header = (TextView) findViewById(R.id.header_1);
        userList = (ListView) findViewById(R.id.list_1);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
        myDb = new DatabaseHelperMethods(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = mDatabaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE_SCHEDULE_DOCTORS + ", " + DatabaseHelper.TABLE_DOCTORS +
                " where " + DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_ID +
                " == '" + KeyValues.sIdDoctor + "' AND " + DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_ID + " == "
                + DatabaseHelper.COLUMN_ID_DOCTOR + " order by " +
                DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_DATETIME, null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_DATETIME};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, R.layout.one_line_list_item,
                userCursor, headers1, new int[]{R.id.text1_1}, 0);
        header.setText("Расписание");
        userList.setAdapter(userAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                int datetimeTicket = myDb.returnDatetime(Long.toString(id));
                String a = Long.toString(id);
                String b = Integer.toString(datetimeTicket);
                Toast.makeText(DatabaseScheduleActivity.this, b, Toast.LENGTH_LONG).show();
//                String nameDoctor = myDb.returnNameDoctor(KeyValues.sIdDoctor);
//                boolean isSign = myDb.insertDataTicket(nameDoctor, KeyValues.sIdPatient, datetimeTicket);
//                if (isSign) {
//                    Toast.makeText(DatabaseScheduleActivity.this, "Талон заказан", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(DatabaseScheduleActivity.this, DescriptionDoctorsActivity.class);
//                    startActivity(intent);
//                } else
//                    Toast.makeText(DatabaseScheduleActivity.this, "Талон не заказан", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}