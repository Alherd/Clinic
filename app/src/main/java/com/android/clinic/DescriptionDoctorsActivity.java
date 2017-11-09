package com.android.clinic;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.clinic.database.DatabaseHelper;

import java.nio.Buffer;

import static com.android.clinic.DatabaseServiceActivity.arg;

public class DescriptionDoctorsActivity extends AppCompatActivity {
    TextView nameDoctors;
    DatabaseHelper mDatabaseHelper;
    SimpleCursorAdapter userAdapter;
    ListView userListDoctor;
    SQLiteDatabase db;
    Cursor userCursor;
    Button button_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_doctors);

        //   nameDoctors = (TextView) findViewById(R.id.nameDoctors);
        userListDoctor = (ListView) findViewById(R.id.list_1);
        button_1 = (Button) findViewById(R.id.button_1);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DescriptionDoctorsActivity.this, arg, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        db = mDatabaseHelper.getReadableDatabase();
        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE_DOCTORS +
                " where " + DatabaseHelper.COLUMN_ID_DOCTOR_1 +
                " = '" + arg + "' ;", null);
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_SPEC, DatabaseHelper.COLUMN_SERV};
        userAdapter = new SimpleCursorAdapter(this, R.layout.one_line_list,
                userCursor, headers1, new int[]{R.id.text1_1, R.id.text2_1, R.id.text3_1}, 0);
        userListDoctor.setAdapter(userAdapter);
        userListDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Doctors mDoctors = new Doctors();
                mDoctors.setId(id);
                arg = mDoctors.getId().toString();
                //  Intent intent = new Intent(DescriptionDoctorsActivity.this, MenuActivity.class);
                //startActivity(intent);
                Toast.makeText(DescriptionDoctorsActivity.this, arg, Toast.LENGTH_LONG).show();

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
