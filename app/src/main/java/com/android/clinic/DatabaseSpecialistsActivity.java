package com.android.clinic;

import android.content.Intent;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FilterQueryProvider;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.android.clinic.database.DatabaseHelper;

/**
 * Created by Olgerd on 15.10.2017.
 */

public class DatabaseSpecialistsActivity extends DatabaseActivity {
    SimpleCursorAdapter userAdapter;

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = mDatabaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE_DOCTORS + " order by " + DatabaseHelper.COLUMN_NAME_DOCTOR, null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers = new String[]{DatabaseHelper.COLUMN_NAME_DOCTOR, DatabaseHelper.COLUMN_SPEC_DOCTOR};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, R.layout.two_line_list,
                userCursor, headers, new int[]{R.id.text1, R.id.text2}, 0);
        header.setText("Наши специалисты");
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

                    return db.rawQuery("select * from " + DatabaseHelper.TABLE_DOCTORS + " order by " + DatabaseHelper.COLUMN_NAME_DOCTOR, null);
                } else {
                    return db.rawQuery("select * from " + DatabaseHelper.TABLE_DOCTORS + " where " +
                            DatabaseHelper.COLUMN_NAME_DOCTOR + " like ? order by " + DatabaseHelper.COLUMN_NAME_DOCTOR, new String[]{"%" + constraint.toString() + "%"});
                }
            }
        });

        userList.setAdapter(userAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Doctors mDoctors = new Doctors();
                mDoctors.setId(id);
                arg = mDoctors.getId().toString();
                Intent intent = new Intent(DatabaseSpecialistsActivity.this, DescriptionDoctorsActivity.class);
                startActivity(intent);
                Toast.makeText(DatabaseSpecialistsActivity.this, arg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
