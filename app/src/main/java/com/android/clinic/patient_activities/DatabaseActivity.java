package com.android.clinic.patient_activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.clinic.R;
import com.android.clinic.database.DatabaseHelper;

public class DatabaseActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    EditText userFilter;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_database);
        header = (TextView) findViewById(R.id.header);
        userList = (ListView) findViewById(R.id.list);
        userFilter = (EditText) findViewById(R.id.userFilter);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
