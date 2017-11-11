package com.android.clinic.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelperMethods extends DatabaseHelper {

    public DatabaseHelperMethods(Context context) {
        super(context);
    }

    public String returnPatientFName(String login) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select " + COLUMN_FNAME + " from " + TABLE_PATIENTS + " where " + COLUMN_LOGIN_PATIENT +
                " = '" + login + "' ;", null);
        b.moveToFirst();
        String nameP = b.getString(b.getColumnIndex(COLUMN_FNAME));
        b.close();
        return nameP;
    }

    public boolean searchLoginPassword(String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select fname from " + TABLE_PATIENTS + " where " + COLUMN_LOGIN_PATIENT +
                " = '" + login + "' and " + COLUMN_PASSWORD_PATIENT + " = '" + password + "';", null);
        if (res.getCount() != 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean searchLogin(String login) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select fname from " + TABLE_PATIENTS + " where " + COLUMN_LOGIN_PATIENT +
                " = '" + login + "';", null);
        if (res.getCount() != 1) {
            return false;
        } else {
            return true;
        }
    }

    public int insertData(String login, String password, String fname, String lname,
                          String pname, String birthday, String email, String address) {
        if ((login.isEmpty()) || (password.isEmpty()) || (fname.isEmpty()) || (lname.isEmpty()) || (pname.isEmpty())
                || (birthday.isEmpty()) || (email.isEmpty()) || (address.isEmpty())) {
            return 0;
        } else if (searchLogin(login)) {
            return 2;
        } else {
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
                return -1;
            else
                return 1;
        }
    }
}
