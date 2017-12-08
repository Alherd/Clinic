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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.TextView;

import com.android.clinic.R;
import com.android.clinic.database.DatabaseHelper;
import com.android.clinic.database.DatabaseHelperMethods;
import com.android.clinic.model.KeyValues;

import static com.android.clinic.database.DatabaseHelper.COLUMN_NAME_DIAGNOSIS;
import static com.android.clinic.database.DatabaseHelper.COLUMN_TYPE_DIAGNOSIS;

public class DiagnosisActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    DatabaseHelperMethods myDb;
    AlertDialog.Builder ad;
    EditText userFilter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_database);

        header = (TextView) findViewById(R.id.header);
        userList = (ListView) findViewById(R.id.list);
        userFilter = (EditText) findViewById(R.id.userFilter);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper = new DatabaseHelper(this);
        myDb = new DatabaseHelperMethods(getApplicationContext());
        myDb = new DatabaseHelperMethods(this);
        context = DiagnosisActivity.this;
    }

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = mDatabaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select _id_diagnosis as _id, * from " + DatabaseHelper.TABLE_DIAGNOSIS_PATIENTS +
                " ;", null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers = new String[]{COLUMN_NAME_DIAGNOSIS, COLUMN_TYPE_DIAGNOSIS};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, R.layout.two_line_button_list_item,
                userCursor, headers, new int[]{R.id.text1, R.id.text2}, 0);
        header.setText("Диагнозы");
        // если в текстовом поле есть текст, выполняем фильтрацию
        // данная проверка нужна при переходе от одной ориентации экрана к другой
        if (!userFilter.getText().toString().isEmpty())
            userAdapter.getFilter().filter(userFilter.getText().toString());

        // установка слушателя изменения текста
        userFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            // при изменении текста выполняем фильтрацию
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                userAdapter.getFilter().filter(s.toString());
            }
        });

        // устанавливаем провайдер фильтрации
        userAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {

                if (constraint == null || constraint.length() == 0) {

                    return db.rawQuery("select _id_diagnosis as _id, * from " + DatabaseHelper.TABLE_DIAGNOSIS_PATIENTS + " order by " +
                            DatabaseHelper.COLUMN_NAME_DIAGNOSIS, null);
                } else {
                    return db.rawQuery("select _id_diagnosis as _id, * from " + DatabaseHelper.TABLE_DIAGNOSIS_PATIENTS + " where " +
                                    DatabaseHelper.COLUMN_NAME_DIAGNOSIS + " like ? order by " + DatabaseHelper.COLUMN_NAME_DIAGNOSIS,
                            new String[]{"%" + constraint.toString() + "%"});
                }
            }
        });

        userList.setAdapter(userAdapter);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, final long id) {
                final String title = myDb.getDiagnosisName(id);
                String message = "Выбрать диагноз?";
                String button1String = "нет";
                String button2String = "да";

                ad = new AlertDialog.Builder(context);
                ad.setTitle(title);
                ad.setMessage(message);
                ad.setPositiveButton(button2String, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        KeyValues.sDiagnosisName = title;
                        KeyValues.sDiagnosisId = Long.toString(id);
                        Intent intent = new Intent(DiagnosisActivity.this, FillPatientCardActivity.class);
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