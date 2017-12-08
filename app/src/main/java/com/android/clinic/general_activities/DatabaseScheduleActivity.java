package com.android.clinic.general_activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.android.clinic.patient_activities.MenuActivity;

import static com.android.clinic.database.DatabaseHelper.COLUMN_SCHEDULE_IS_ORDER;

public class DatabaseScheduleActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_database_schedule);

        header = (TextView) findViewById(R.id.header_1);
        userList = (ListView) findViewById(R.id.list_1);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
        myDb = new DatabaseHelperMethods(this);
        context = DatabaseScheduleActivity.this;

    }

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = mDatabaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select _id_schedule as _id, * from " + DatabaseHelper.TABLE_SCHEDULE_DOCTORS
                + " where " + DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_ID +
                " == '" + KeyValues.sIdDoctor + "' AND " + COLUMN_SCHEDULE_IS_ORDER + " == '0' order by " +
                DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_DATETIME, null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_SCHEDULE_DOCTORS_DATETIME};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, R.layout.one_line_list_item,
                userCursor, headers1, new int[]{R.id.text1_1_1}, 0);
        header.setText("Расписание");
        userList.setAdapter(userAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, final long id) {
                if (!KeyValues.enterLikeDoctor) {
                    String title = myDb.getDateTime(id);
                    String message = "Заказать талон?";
                    String button1String = "нет";
                    String button2String = "да";

                    ad = new AlertDialog.Builder(context);
                    ad.setTitle(title);
                    ad.setMessage(message);

                    ad.setPositiveButton(button2String, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            if (KeyValues.sIsSignUp) {
                                boolean orderTicket = myDb.insertDataPatientTicket(KeyValues.sIdPatient, id);
                                if (orderTicket) {
                                    Toast.makeText(DatabaseScheduleActivity.this, "Талон заказан", Toast.LENGTH_LONG).show();
                                    myDb.updateDataTicketPatientsOff(id);
                                    Intent intent = new Intent(DatabaseScheduleActivity.this, MenuActivity.class);
                                    startActivity(intent);
                                } else
                                    Toast.makeText(DatabaseScheduleActivity.this, "Талон не заказан", Toast.LENGTH_LONG).show();
                            } else
                                Toast.makeText(DatabaseScheduleActivity.this, "Авторизируйтесь для заказа талона", Toast.LENGTH_LONG).show();
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
                }
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