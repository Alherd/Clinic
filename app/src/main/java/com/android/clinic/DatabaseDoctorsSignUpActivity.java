package com.android.clinic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.android.clinic.database.DatabaseHelper;

public class DatabaseDoctorsSignUpActivity extends AppCompatActivity {
    SimpleCursorAdapter userAdapter;
    ListView userList;
    TextView header;
    EditText userFilter;
    DatabaseHelper mDatabaseHelper;
    SQLiteDatabase db;
    Button button_sign_up;
    Cursor userCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_database);
        header = (TextView) findViewById(R.id.header);
        userList = (ListView) findViewById(R.id.list);
        userFilter = (EditText) findViewById(R.id.userFilter);
        button_sign_up = (Button) findViewById(R.id.id_sign_up);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = mDatabaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE_DOCTORS + " order by " +
                DatabaseHelper.COLUMN_NAME, null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers1 = new String[]{DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_SPEC};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, R.layout.two_line_button_list_item,
                userCursor, headers1, new int[]{R.id.text1, R.id.text2}, 0);
        header.setText("Наши врачи");

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

                    return db.rawQuery("select * from " + DatabaseHelper.TABLE_DOCTORS + " order by " +
                            DatabaseHelper.COLUMN_NAME, null);
                } else {
                    return db.rawQuery("select * from " + DatabaseHelper.TABLE_DOCTORS + " where " +
                                    DatabaseHelper.COLUMN_NAME + " like ? order by " + DatabaseHelper.COLUMN_NAME,
                            new String[]{"%" + constraint.toString() + "%"});
                }
            }
        });

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
