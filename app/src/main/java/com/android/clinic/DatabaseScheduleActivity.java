package com.android.clinic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.clinic.database.DatabaseHelper;

public class DatabaseScheduleActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_schedule);

        header = (TextView) findViewById(R.id.header_1);
        userList = (ListView) findViewById(R.id.list_1);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = mDatabaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE_SCHEDULE_DOCTORS +
                " where " + DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_ID +
                " = '" + KeyValues.sIdDoctor + "' ;", null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_MONDAY};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, R.layout.one_line_list_item,
                userCursor, headers1, new int[]{R.id.text1_1}, 0);
        header.setText("Расписание");
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