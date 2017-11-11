package com.android.clinic.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "clinicBase.db";

    public static final String TABLE_DOCTORS = "doctors"; // название таблицы в бд
    public static final String COLUMN_ID_DOCTOR_1 = "_id";
    public static final String COLUMN_NAME_DOCTOR = "name";
    public static final String COLUMN_SPEC_DOCTOR = "spec";
    public static final String COLUMN_SERV_DOCTOR = "service";
    public static final String COLUMN_AGE_DOCTOR = "birthday";
    public static final String COLUMN_EXPER_DOCTOR = "experience";

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
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME_DOCTOR
                + " TEXT, " + COLUMN_SPEC_DOCTOR + " TEXT, " + COLUMN_AGE_DOCTOR
                + " TEXT, " + COLUMN_EXPER_DOCTOR + " TEXT, " + COLUMN_SERV_DOCTOR + " TEXT);");


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

        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('1' , 'Иванов Сергей', 'Лор', ' 35 лет', ' 15 лет', 'Лечение лор-заболеваний');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('2', 'Сидорова Ольга', 'Терапевт', '46 лет', '23 года', 'Первичный прием');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('3', 'Аверин Дмитрий', 'Анестезиолог', '41 год', '12 лет','Анестезиология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('4', 'Журавлев Ростислав', 'Офтальмолог','23 года','2 года', 'Офтальмология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('5', 'Князев Матвей', 'Кардиолог', '31 год', '6 лет', 'Кардиология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('6', 'Крылова Тамара', 'Педиатр', '54 года', '32 года', 'Педиатрия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('7', 'Матвеева Алиса', 'Гинеколог', '40 лет', '17 лет', 'Гинекология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('8', 'Воронцова Татьяна', 'Криотерапевт', '28 лет', '5 лет', 'Криотерапия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('9', 'Воронов Игорь', 'Эндокринолог', '36 лет', '13 лет', 'Эндрокринология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('10', 'Якубов Александр', 'Хирург', '39 лет', '15 лет', 'Хирургия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('11', 'Фомина Софья', 'Косметолог', '24 года', '3 года', 'Косметология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('12', 'Шаповалова Виктория', 'Кардиолог', '25 лет', '3 года', 'Кардиология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('13', 'Борцова Анастасия', 'Процендурная медсестра', '22 года', '1 год', 'Терапевтия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('14', 'Семченко Никита', 'Лор', '42 года', '20 лет', 'Лечение лор-заболеваний');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('15', 'Полищук Александр', 'Терапевт', '36 лет', '13 лет', 'Терапевтия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('16', 'Климец Александр', 'Терапевт', '34 года', '10 лет',  'Терапевтия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('17', 'Музыка Александра', 'Косметолог', '28 лет', '5 лет', 'Косметология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('18', 'Туболец Юлия', 'Эндокринолог', '41 год', '19 лет', 'Эндокринология');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('19', 'Юревич Алевтина', 'Педиатр', '29 лет', '7 лет', 'Педиатрия');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR_1 + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ") VALUES ('20', 'Иванов Стас', 'Хирург', '44 года', '20 лет', 'Хирургия');");

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
        onCreate(db);
    }
}
