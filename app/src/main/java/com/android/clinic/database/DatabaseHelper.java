package com.android.clinic.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "clinicBase.db";

    public static final String COLUMN_ID_DOCTOR_1 = "_id";
    //public static final String COLUMN_ID_DOCTOR_2 = "_id";

    public static final String TABLE_DOCTORS = "doctors"; // название таблицы в бд
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SPEC = "spec";
    public static final String COLUMN_SERV = "service";

    public static final String TABLE_PASSWORD_DOCTORS = "doctors_password"; // название таблицы в бд
    //public static final String COLUMN_LOGIN_DOCTOR = "login";
    //public static final String COLUMN_PASSWORD_DOCTOR = "password";

    public static final String TABLE_PATIENTS = "patients"; // название таблицы в бд
    public static final String COLUMN_ID_PATIENT = "_id_patient";
    public static final String COLUMN_LOGIN_PATIENT = "login";
    public static final String COLUMN_PASSWORD_PATIENT = "password";
    public static final String COLUMN_FNAME = "fname";
    public static final String COLUMN_LNAME = "lname";
    public static final String COLUMN_PNAME = "patronymic";
    public static final String COLUMN_BIRTH = "birthday";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_EMAIL = "email";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT, " + COLUMN_SPEC + " TEXT, " + COLUMN_SERV + " TEXT);");

//        db.execSQL("CREATE TABLE_PATIENTS " + TABLE_PASSWORD_DOCTORS + " (" + COLUMN_ID_DOCTOR_2
//                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_LOGIN_DOCTOR
//                + " TEXT, " + COLUMN_PASSWORD_DOCTOR + " TEXT);");

        db.execSQL("CREATE TABLE " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_LOGIN_PATIENT + " TEXT, "
                + COLUMN_PASSWORD_PATIENT + " TEXT, "
                + COLUMN_FNAME + " TEXT, "
                + COLUMN_LNAME + " TEXT, "
                + COLUMN_PNAME + " TEXT, "
                + COLUMN_BIRTH + " DATETIME, "
                + COLUMN_ADDRESS + " TEXT, "
                + COLUMN_EMAIL + " TEXT);");

        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('1' , 'Иванов Сергей', 'Лор', 'Лечение лор-заболеваний');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('2', 'Сидорова Ольга', 'Терапевт', 'Первичный прием');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('3', 'Аверин Дмитрий', 'Анестезиолог','Анестезиология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('4', 'Журавлев Ростислав', 'Офтальмолог', 'Офтальмология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('5', 'Князев Матвей', 'Кардиолог', 'Кардиология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('6', 'Крылова Тамара', 'Педиатр', 'Педиатрия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('7', 'Матвеева Алиса', 'Гинеколог', 'Гинекология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('8', 'Воронцова Татьяна', 'Криотерапевт', 'Криотерапия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('9', 'Воронов Игорь', 'Эндокринолог', 'Эндрокринология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('10', 'Якубов Александр', 'Хирург', 'Хирургия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('11', 'Фомина Софья', 'Косметолог', 'Косметология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('12', 'Жданович Виктория', 'Кардиолог', 'Косметология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('13', 'Врублевская Анастасия', 'Процендурная медсестра', 'Терапевтия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('14', 'Семченко Никита', 'Лор', 'Лечение лор-заболеваний');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('15', 'Полищук Александр', 'Терапевт', 'Терапевтия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('16', 'Климец Александр', 'Терапевт', 'Терапевтия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('17', 'Музыка Александра', 'Косметолог', 'Косметология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('18', 'Туболец Юлия', 'Эндокринолог', 'Эндокринология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('19', 'Юревич Алевтина', 'Педиатр', 'Педиатрия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME
                + ", " + COLUMN_SPEC + ", " + COLUMN_SERV + ") VALUES ('20', 'Иванов Стас', 'Хирург', 'Хирургия');");


        //
//        db.execSQL("INSERT INTO " + TABLE_PASSWORD_DOCTORS + " (" + COLUMN_ID_DOCTOR_2 + ", " + COLUMN_LOGIN_DOCTOR
//                + ", " + COLUMN_PASSWORD_DOCTOR + ") VALUES ('1' , 'Сергей', '12345');");
//        db.execSQL("INSERT INTO " + TABLE_PASSWORD_DOCTORS + " (" + COLUMN_ID_DOCTOR_2 + ", " + COLUMN_LOGIN_DOCTOR
//                + ", " + COLUMN_PASSWORD_DOCTOR + ") VALUES ('2' , 'Ольга', '11111');");
//        db.execSQL("INSERT INTO " + TABLE_PASSWORD_DOCTORS + " (" + COLUMN_ID_DOCTOR_2 + ", " + COLUMN_LOGIN_DOCTOR
//                + ", " + COLUMN_PASSWORD_DOCTOR + ") VALUES ('3' , 'Дмитрий', '33333');");
//        db.execSQL("INSERT INTO " + TABLE_PASSWORD_DOCTORS + " (" + COLUMN_ID_DOCTOR_2 + ", " + COLUMN_LOGIN_DOCTOR
//                + ", " + COLUMN_PASSWORD_DOCTOR + ") VALUES ('4' , 'Ростислав', '44444');");
//        db.execSQL("INSERT INTO " + TABLE_PASSWORD_DOCTORS + " (" + COLUMN_ID_DOCTOR_2 + ", " + COLUMN_LOGIN_DOCTOR
//                + ", " + COLUMN_PASSWORD_DOCTOR + ") VALUES ('5' , 'Матвей', '55555');");

        db.execSQL("INSERT INTO " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT + ", " + COLUMN_LOGIN_PATIENT
                + ", " + COLUMN_PASSWORD_PATIENT + ", " + COLUMN_FNAME
                + ", " + COLUMN_LNAME + ", " + COLUMN_PNAME + ", " + COLUMN_BIRTH + ", "
                + COLUMN_ADDRESS + ", " + COLUMN_EMAIL + ") VALUES ('1', 'ангелина', '111', 'Ангелина', 'Бобришёва', " +
                "'Николаевна','21.03.1998','ул. Неманская 25, 51', 'angelina@gmail.com');");
        db.execSQL("INSERT INTO " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT + ", " + COLUMN_LOGIN_PATIENT
                + ", " + COLUMN_PASSWORD_PATIENT + ", " + COLUMN_FNAME
                + ", " + COLUMN_LNAME + ", " + COLUMN_PNAME + ", " + COLUMN_BIRTH + ", "
                + COLUMN_ADDRESS + ", " + COLUMN_EMAIL + ") VALUES ('2', 'павел', '222', 'Павел', 'Жданович'," +
                " 'Константинович','12.09.1996','ул. Колесникова 8,23', 'pavel@tut.by');");
        db.execSQL("INSERT INTO " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT + ", " + COLUMN_LOGIN_PATIENT
                + ", " + COLUMN_PASSWORD_PATIENT + ", " + COLUMN_FNAME
                + ", " + COLUMN_LNAME + ", " + COLUMN_PNAME + ", " + COLUMN_BIRTH + ", "
                + COLUMN_ADDRESS + ", " + COLUMN_EMAIL + ") VALUES ('3','виктория', '333', 'Виктория', 'Левчук'," +
                " 'Александровна','31.12.1995','ул. Налибоцкая 3,14', 'vika@rambler.ru');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exist" + DATABASE_NAME);
        onCreate(db);
    }

    public boolean insearch(String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select fname from " + TABLE_PATIENTS + " where " + COLUMN_LOGIN_PATIENT +
                " = '" + login + "' and " + COLUMN_PASSWORD_PATIENT + " = '" + password + "';", null);
        if (res.getCount() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertData(String login, String password, String fname, String lname,
                              String pname, String birthday, String email, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        long m = (long) (Math.random() * Long.MAX_VALUE);
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID_PATIENT, m);
        contentValues.put(COLUMN_LOGIN_PATIENT, login);
        contentValues.put(COLUMN_PASSWORD_PATIENT, password);
        contentValues.put(COLUMN_FNAME, fname);
        contentValues.put(COLUMN_LNAME, lname);
        contentValues.put(COLUMN_PNAME, pname);
        contentValues.put(COLUMN_BIRTH, birthday);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_ADDRESS, address);
        long result = db.insert(TABLE_PATIENTS, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
