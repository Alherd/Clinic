package com.android.clinic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.clinic.database.DatabaseHelper;

public class DatabaseActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Button button_sign_up;
    Cursor userCursor;
    EditText userFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_database);
        header = (TextView) findViewById(R.id.header);
        userList = (ListView) findViewById(R.id.list);
        userFilter = (EditText) findViewById(R.id.userFilter);
        button_sign_up = (Button) findViewById(R.id.id_sign_up);
        databaseHelper = new DatabaseHelper(getApplicationContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }

}
