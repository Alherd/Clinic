package com.android.clinic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.android.clinic.database.ExaminationBaseHelper.COLUMN_DIAGNOSIS_COD;

public class DiagnosisBaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "clinicBase.db";
    public static final String TABLE = "diagnosis"; // название таблицы в бд
    public static final String COLUMN_DIAGNOSIS_NAME = "diagnosis_name";
    public static final String COLUMN_DIAGNOSIS_BLOCK = "diagnosis_block";
    public static final String COLUMN_DIAGNOSIS_CLASS = "diagnosis_class";

    public DiagnosisBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE diagnosis (" + COLUMN_DIAGNOSIS_COD
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_DIAGNOSIS_NAME
                + " TEXT, " + COLUMN_DIAGNOSIS_BLOCK + " TEXT, " + COLUMN_DIAGNOSIS_CLASS
                + " TEXT);");

        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_DIAGNOSIS_COD + ", " + COLUMN_DIAGNOSIS_NAME
                + ", " + COLUMN_DIAGNOSIS_BLOCK + ", " + COLUMN_DIAGNOSIS_CLASS + ")" +
                " VALUES ('1', 'Шизофрения', 'Болезни', 'Излечимая болезнь');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
