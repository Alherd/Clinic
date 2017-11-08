package com.android.clinic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExaminationBaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "clinicBase.db";
    public static final String TABLE = "examinations"; // название таблицы в бд
    public static final String COLUMN_ID_DOCTOR = "_id";
    public static final String COLUMN_DIAGNOSIS_COD = "diagnosis_cod";
    public static final String COLUMN_ID_PATIENT = "_id_patient";
    public static final String COLUMN_ID_SIGN_UP = "_id_sign_up";
    public static final String COLUMN_DATE_TREATMENT = "date_treatment";

    public ExaminationBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE examinations (" + COLUMN_ID_SIGN_UP
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ID_PATIENT
                + " INTEGER, " + COLUMN_ID_DOCTOR + " INTEGER, " + COLUMN_DATE_TREATMENT
                + " TEXT, " + COLUMN_DIAGNOSIS_COD
                + " INTEGER);");

        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_ID_SIGN_UP + ", " + COLUMN_ID_PATIENT
                + ", " + COLUMN_ID_DOCTOR + ", " + COLUMN_DATE_TREATMENT + ", " + COLUMN_DIAGNOSIS_COD + ")" +
                " VALUES ('1', '4', '7', '27.10.2017', '12');");
        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_ID_SIGN_UP + ", " + COLUMN_ID_PATIENT
                + ", " + COLUMN_ID_DOCTOR + ", " + COLUMN_DATE_TREATMENT + ", " + COLUMN_DIAGNOSIS_COD + ")" +
                " VALUES ('2', '9', '2', '22.09.2017', '20');");
        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_ID_SIGN_UP + ", " + COLUMN_ID_PATIENT
                + ", " + COLUMN_ID_DOCTOR + ", " + COLUMN_DATE_TREATMENT + ", " + COLUMN_DIAGNOSIS_COD + ")" +
                " VALUES ('3', '13', '18', '29.10.2017', '3');");
        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_ID_SIGN_UP + ", " + COLUMN_ID_PATIENT
                + ", " + COLUMN_ID_DOCTOR + ", " + COLUMN_DATE_TREATMENT + ", " + COLUMN_DIAGNOSIS_COD + ")" +
                " VALUES ('4', '6', '11', '23.10.2017', '15');");
        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_ID_SIGN_UP + ", " + COLUMN_ID_PATIENT
                + ", " + COLUMN_ID_DOCTOR + ", " + COLUMN_DATE_TREATMENT + ", " + COLUMN_DIAGNOSIS_COD + ")" +
                " VALUES ('5', '1', '15', '01.11.2017', '10');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exist" + DATABASE_NAME);
        onCreate(db);
    }
}
