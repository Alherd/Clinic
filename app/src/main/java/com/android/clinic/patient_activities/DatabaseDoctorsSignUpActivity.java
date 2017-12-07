package com.android.clinic.patient_activities;

import android.content.Intent;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FilterQueryProvider;
import android.support.v4.widget.SimpleCursorAdapter;

import com.android.clinic.model.Doctors;
import com.android.clinic.model.KeyValues;
import com.android.clinic.R;
import com.android.clinic.database.DatabaseHelper;

public class DatabaseDoctorsSignUpActivity extends DatabaseActivity {

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = mDatabaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select _id_doctor as _id, * from " + DatabaseHelper.TABLE_DOCTORS + " order by " +
                DatabaseHelper.COLUMN_NAME_DOCTOR, null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_NAME_DOCTOR, DatabaseHelper.COLUMN_SPEC_DOCTOR};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, R.layout.two_line_list_item,
                userCursor, headers1, new int[]{R.id.text1, R.id.text2}, 0);
        header.setText("Запись к врачу");

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

                    return db.rawQuery("select _id_doctor as _id, * from " + DatabaseHelper.TABLE_DOCTORS + " order by " +
                            DatabaseHelper.COLUMN_NAME_DOCTOR, null);
                } else {
                    return db.rawQuery("select _id_doctor as _id, * from " + DatabaseHelper.TABLE_DOCTORS + " where " +
                                    DatabaseHelper.COLUMN_NAME_DOCTOR + " like ? order by " + DatabaseHelper.COLUMN_NAME_DOCTOR,
//                                    " OR " + DatabaseHelper.COLUMN_SPEC_DOCTOR + " like ? order by " + DatabaseHelper.COLUMN_NAME_DOCTOR,
                            new String[]{"%" + constraint.toString() + "%"});
                }
            }
        });

        userList.setAdapter(userAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Doctors mDoctors = new Doctors();
                mDoctors.setId(id);
                KeyValues.sIdDoctor = mDoctors.getId().toString();
                Intent intent = new Intent(DatabaseDoctorsSignUpActivity.this, DescriptionDoctorsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
