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
        Cursor b = db.rawQuery("select " + COLUMN_FNAME_PATIENT + " from " + TABLE_PATIENTS + " where " + COLUMN_LOGIN_PATIENT +
                " = '" + login + "' ;", null);
        b.moveToFirst();
        String nameP = b.getString(b.getColumnIndex(COLUMN_FNAME_PATIENT));
        b.close();
        return nameP;
    }

    public String returnPatientID(String login) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select " + COLUMN_ID_PATIENT + " from " + TABLE_PATIENTS + " where " + COLUMN_LOGIN_PATIENT +
                " = '" + login + "' ;", null);
        b.moveToFirst();
        String name_id = b.getString(b.getColumnIndex(COLUMN_ID_PATIENT));
        b.close();
        return name_id;
    }

    public String searchLoginPassword(String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resPatient = db.rawQuery("select * from " + TABLE_PATIENTS + " where " + COLUMN_LOGIN_PATIENT +
                " = '" + login + "' and " + COLUMN_PASSWORD_PATIENT + " = '" + password + "';", null);
        Cursor resDoctor = db.rawQuery("select * from " + TABLE_DOCTORS + " where " + COLUMN_LOGIN_DOCTOR +
                " = '" + login + "' and " + COLUMN_PASSWORD_DOCTOR + " = '" + password + "';", null);
        if (resPatient.getCount() == 1) {
            resPatient.moveToFirst();
            String idPat = resPatient.getString(resPatient.getColumnIndex(COLUMN_ID_PATIENT));
            resPatient.close();
            resDoctor.close();
            return idPat;
        } else if (resDoctor.getCount() == 1) {
            resDoctor.moveToFirst();
            String idDoc = resDoctor.getString(resDoctor.getColumnIndex(COLUMN_ID_DOCTOR));
            resPatient.close();
            resDoctor.close();
            return idDoc;
        } else {
            resPatient.close();
            resDoctor.close();
            return "-1";
        }
    }

    public boolean searchLogin(String login) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resPat = db.rawQuery("select * from " + TABLE_PATIENTS + " where " + COLUMN_LOGIN_PATIENT +
                " = '" + login + "' ;", null);
        Cursor resDoc = db.rawQuery("select * from " + TABLE_DOCTORS + " where " + COLUMN_LOGIN_DOCTOR +
                " = '" + login + "' ;", null);
        if (resPat.getCount() + resDoc.getCount() == 0) {
            resDoc.close();
            resPat.close();
            return false;
        } else {
            resDoc.close();
            resPat.close();
            return true;
        }
    }

    public int insertData(String login, String password, String fname, String lname,
                          String pname, String email, String address) {
        if ((login.isEmpty()) || (password.isEmpty()) || (fname.isEmpty()) || (lname.isEmpty()) || (pname.isEmpty())
                || (email.isEmpty()) || (address.isEmpty())) {
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
            contentValues.put(COLUMN_FNAME_PATIENT, fname);
            contentValues.put(COLUMN_LNAME_PATIENT, lname);
            contentValues.put(COLUMN_PNAME_PATIENT, pname);
            contentValues.put(COLUMN_PHONE_PATIENT, email);
            contentValues.put(COLUMN_ADDRESS_PATIENT, address);
            long result = db.insert(TABLE_PATIENTS, null, contentValues);
            if (result == -1)
                return -1;
            else
                return 1;
        }
    }

    public boolean insertDataPatientTicket(String idPatient, long idTicket) {
        SQLiteDatabase db = this.getWritableDatabase();
        long m = (long) (Math.random() * Long.MAX_VALUE);
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SIGN_UP_ID, m);
        contentValues.put(COLUMN_SIGN_UP_ID_PATIENTS, idPatient);
        contentValues.put(COLUMN_SIGN_UP_ID_TICKET, idTicket);
        contentValues.put(COLUMN_SIGN_UP_IS_OVER, "0");
        long result = db.insert(TABLE_SIGN_UP_PATIENTS, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public void removeDataPatientTicket(String idPatient, long idTicket) {
        SQLiteDatabase db = this.getWritableDatabase();

//        db.rawQuery("delete from " + TABLE_SIGN_UP_PATIENTS + " where " + COLUMN_SIGN_UP_ID_TICKET +
//                " = '" + idTicket + "' and " + COLUMN_SIGN_UP_ID_PATIENTS + " = '" + idPatient + "';", null);
        db.delete(TABLE_SIGN_UP_PATIENTS, COLUMN_SIGN_UP_ID + " = '" + idTicket +
                "' AND " + COLUMN_SIGN_UP_ID_PATIENTS + " = '" + idPatient + "'", null);
    }

    public void updateDataTicketPatientsOn(long idTicket) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COLUMN_SIGN_UP_ID_TICKET + " from " + TABLE_SIGN_UP_PATIENTS + " where " + COLUMN_SIGN_UP_ID +
                " = '" + idTicket + "' ;", null);
        res.moveToFirst();
        String ticket_id = res.getString(res.getColumnIndex(COLUMN_SIGN_UP_ID_TICKET));
        res.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TICKET_IS_ORDER, "0");
        db.update(TABLE_TICKETS_DOCTORS, contentValues, COLUMN_TICKET_ID + " = '" + ticket_id + "'",
                null);
    }

    public void updateDataTicketPatientsOff(long idTicket) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TICKET_IS_ORDER, "1");
        db.update(TABLE_TICKETS_DOCTORS, contentValues, COLUMN_TICKET_ID + " = " + idTicket,
                null);
    }

    public void updateDataTicketFinal(long idTicket) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SIGN_UP_IS_OVER, "1");
        db.update(TABLE_SIGN_UP_PATIENTS, contentValues, COLUMN_SIGN_UP_ID + " = " + idTicket,
                null);
    }

    public String returnNameDoctor(String idDoctor) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select " + COLUMN_NAME_DOCTOR + " from " + TABLE_DOCTORS + " where " + COLUMN_ID_DOCTOR +
                " = '" + idDoctor + "' ;", null);
        b.moveToFirst();
        String nameDoctor = b.getString(b.getColumnIndex(COLUMN_NAME_DOCTOR));
        b.close();
        return nameDoctor;
    }

    public String getDateTime(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_TICKETS_DOCTORS +
                " where " + COLUMN_TICKET_ID + " = '" + id + "' ;", null);
        b.moveToFirst();
        String dateTime = b.getString(b.getColumnIndex(COLUMN_TICKET_DOCTORS_DATETIME));
        b.close();
        return dateTime;
    }

    public String getImage(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_DOCTORS +
                " where " + COLUMN_ID_DOCTOR + " = '" + id + "' ;", null);
        b.moveToFirst();
        String photoDoctor = b.getString(b.getColumnIndex(COLUMN_PHOTO_DOCTOR));
        b.close();
        return photoDoctor;
    }

    public String getDateTimeSign(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_SIGN_UP_PATIENTS + ", " + TABLE_TICKETS_DOCTORS + " where " +
                COLUMN_SIGN_UP_ID + " = '" + id + "' and " + COLUMN_SIGN_UP_ID_TICKET + " = " + COLUMN_TICKET_ID + ";", null);
        b.moveToFirst();
        String dateTimeSign = b.getString(b.getColumnIndex(COLUMN_TICKET_DOCTORS_DATETIME));
        b.close();
        return dateTimeSign;
    }

    public String getLoginFromPhone(String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_PATIENTS + " where " + COLUMN_PHONE_PATIENT + " == '" +
                phone + "' ;", null);
        if (b.getCount() == 1) {
            b.moveToFirst();
            String login = b.getString(b.getColumnIndex(COLUMN_LOGIN_PATIENT));
            b.close();
            return login;
        } else {
            b.close();
            return "";
        }
    }

    public String getPasswordFromPhone(String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_PATIENTS + " where " + COLUMN_PHONE_PATIENT + " == '" +
                phone + "' ;", null);
        if (b.getCount() == 1) {
            b.moveToFirst();
            String login = b.getString(b.getColumnIndex(COLUMN_PASSWORD_PATIENT));
            b.close();
            return login;
        } else {
            b.close();
            return "";
        }
    }

    public String getDiagnosisName(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_DIAGNOSIS_PATIENTS + " where " +
                COLUMN_ID_DIAGNOSIS + " == '" + id + "';", null);
        b.moveToFirst();
        String diagnosis = b.getString(b.getColumnIndex(COLUMN_NAME_DIAGNOSIS));
        b.close();
        return diagnosis;
    }

    public String getFnamePatient(String idTicket) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_SIGN_UP_PATIENTS + ", " + TABLE_PATIENTS + " where " +
                COLUMN_SIGN_UP_ID + " == '" + idTicket + "' and " + COLUMN_SIGN_UP_ID_PATIENTS + " == " + COLUMN_ID_PATIENT +
                " ;", null);
        b.moveToFirst();
        String lName = b.getString(b.getColumnIndex(COLUMN_LNAME_PATIENT));
        b.close();
        return lName;
    }

    public String getTimeVisit(String idTicket) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_SIGN_UP_PATIENTS + ", " + TABLE_TICKETS_DOCTORS + " where " +
                COLUMN_SIGN_UP_ID + " == '" + idTicket + "' and " + COLUMN_SIGN_UP_ID_TICKET + " == " + COLUMN_TICKET_ID +
                " ;", null);
        b.moveToFirst();
        String dateTime = b.getString(b.getColumnIndex(COLUMN_TICKET_DOCTORS_DATETIME));
        b.close();
        return dateTime;
    }

    public String getIdPatient(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor b = db.rawQuery("select * from " + TABLE_SIGN_UP_PATIENTS + ", " + TABLE_TICKETS_DOCTORS + ", " +
                TABLE_PATIENTS + " where " + COLUMN_SIGN_UP_ID + " == '" + id + "' and " + COLUMN_SIGN_UP_ID_PATIENTS +
                " == " + COLUMN_ID_PATIENT + " ;", null);
        b.moveToFirst();
        String dateTime = b.getString(b.getColumnIndex(COLUMN_ID_PATIENT));
        b.close();
        return dateTime;
    }

    public boolean setDataToCard(String idTicket, String idDiagnosis, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        if ((idTicket.equals("")) || (idDiagnosis.equals(""))) {
            return false;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_SIGN_ID_CARD, idTicket);
            contentValues.put(COLUMN_DIAGNOSIS_COD_CARD, idDiagnosis);
            contentValues.put(COLUMN_NOTE_DOCTOR_CARD, note);
            long result = db.insert(TABLE_MEDICAL_CARD_PATIENTS, null, contentValues);
            if (result == -1)
                return false;
            else

                return true;
        }
    }
}

