package com.android.clinic;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.clinic.database.DatabaseHelper;
import com.android.clinic.database.DatabaseHelperMethods;

import java.io.InputStream;


public class DescriptionDoctorsActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    DatabaseHelperMethods mDatabaseHelperMethods;
    SimpleCursorAdapter userAdapter;
    ListView userListDoctor;
    SQLiteDatabase db;
    Cursor userCursor;
    Button button_1;
    ImageView photoDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_doctors);

        userListDoctor = (ListView) findViewById(R.id.list_1);
        button_1 = (Button) findViewById(R.id.button_1);
        photoDoctor = (ImageView) findViewById(R.id.photo_doctor);

        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
        mDatabaseHelperMethods = new DatabaseHelperMethods(getApplicationContext());
        mDatabaseHelperMethods = new DatabaseHelperMethods(this);
        InputStream is = getClass().getClassLoader().getResourceAsStream(mDatabaseHelperMethods.getImage(KeyValues.sIdDoctor));
        Bitmap bm = BitmapFactory.decodeStream(is);
        photoDoctor.setImageBitmap(bm);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DescriptionDoctorsActivity.this, DatabaseScheduleActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        db = mDatabaseHelper.getReadableDatabase();
        userCursor = db.rawQuery("select _id_doctor as _id, * from " + DatabaseHelper.TABLE_DOCTORS +
                " where " + DatabaseHelper.COLUMN_ID_DOCTOR +
                " = '" + KeyValues.sIdDoctor + "' ;", null);
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_NAME_DOCTOR, DatabaseHelper.COLUMN_SPEC_DOCTOR,
                DatabaseHelper.COLUMN_SERV_DOCTOR, DatabaseHelper.COLUMN_TIME_DOCTOR, DatabaseHelper.COLUMN_EXPER_DOCTOR};
        userAdapter = new SimpleCursorAdapter(this, R.layout.three_line_list,
                userCursor, headers1, new int[]{R.id.text1_1, R.id.text2_1, R.id.text3_1, R.id.text4_1, R.id.text5_1}, 0);
        userListDoctor.setAdapter(userAdapter);
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
