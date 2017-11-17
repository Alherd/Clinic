package com.android.clinic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "clinicBase.db";

    public static final String TABLE_DOCTORS = "doctors"; // название таблицы в бд
    public static final String COLUMN_ID_DOCTOR = "_id";
    public static final String COLUMN_NAME_DOCTOR = "name_doctor";
    public static final String COLUMN_SPEC_DOCTOR = "spec_doctor";
    public static final String COLUMN_SERV_DOCTOR = "service_doctor";
    public static final String COLUMN_AGE_DOCTOR = "age_doctor";
    public static final String COLUMN_EXPER_DOCTOR = "experience_doctor";
    public static final String COLUMN_CABINET_DOCTOR = "cabinet_doctor";

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

    public static final String TABLE_SCHEDULE_DOCTORS = "schedule_doctors";
    public static final String COLUMN_SCHEDULE_DOCTORS_ID = "_id";
    public static final String COLUMN_SCHEDULE_DOCTORS_MONDAY = "doctor_monday";
    public static final String COLUMN_SCHEDULE_DOCTORS_TUESDAY = "doctor_tuesday";
    public static final String COLUMN_SCHEDULE_DOCTORS_WEDNESDAY = "doctor_wednesday";
    public static final String COLUMN_SCHEDULE_DOCTORS_THURSDAY = "doctor_thursday";
    public static final String COLUMN_SCHEDULE_DOCTORS_FRIDAY = "doctor_friday";
    public static final String COLUMN_SCHEDULE_DOCTORS_SATURDAY = "doctor_saturday";
    public static final String COLUMN_SCHEDULE_DOCTORS_SUNDAY = "doctor_sunday";

    public static final String TABLE_MEDICAL_CARD_PATIENTS = "map_patients";
    public static final String COLUMN_ID_MAP = "_id";
    public static final String COLUMN_ID_PATIENT_MAP = "id_patient";
    public static final String COLUMN_ID_DOCTOR_MAP = "id_doctor";
    public static final String COLUMN_DATE_MAP = "date_map";
    public static final String COLUMN_DIAGNOSIS_COD_MAP = "diagnosis_cod_map";
    public static final String COLUMN_NOTE_DOCTOR_MAP = "note_doctor_map";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_DOCTORS
                + " (" + COLUMN_ID_DOCTOR
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME_DOCTOR + " TEXT, "
                + COLUMN_SPEC_DOCTOR + " TEXT, "
                + COLUMN_AGE_DOCTOR + " TEXT, "
                + COLUMN_EXPER_DOCTOR + " TEXT, "
                + COLUMN_SERV_DOCTOR + " TEXT, "
                + COLUMN_CABINET_DOCTOR + " TEXT);");


        db.execSQL("CREATE TABLE " + TABLE_PATIENTS
                + " (" + COLUMN_ID_PATIENT
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_LOGIN_PATIENT + " TEXT, "
                + COLUMN_PASSWORD_PATIENT + " TEXT, "
                + COLUMN_FNAME + " TEXT, "
                + COLUMN_LNAME + " TEXT, "
                + COLUMN_PNAME + " TEXT, "
                + COLUMN_BIRTH + " DATETIME, "
                + COLUMN_ADDRESS + " TEXT, "
                + COLUMN_EMAIL + " TEXT);");


        db.execSQL("CREATE TABLE " + TABLE_SCHEDULE_DOCTORS
                + " (" + COLUMN_SCHEDULE_DOCTORS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SCHEDULE_DOCTORS_MONDAY + " TEXT, "
                + COLUMN_SCHEDULE_DOCTORS_TUESDAY + " TEXT, "
                + COLUMN_SCHEDULE_DOCTORS_WEDNESDAY + " TEXT, "
                + COLUMN_SCHEDULE_DOCTORS_THURSDAY + " TEXT, "
                + COLUMN_SCHEDULE_DOCTORS_FRIDAY + " TEXT, "
                + COLUMN_SCHEDULE_DOCTORS_SATURDAY + " TEXT, "
                + COLUMN_SCHEDULE_DOCTORS_SUNDAY + " TEXT);");


        db.execSQL("CREATE TABLE " + TABLE_MEDICAL_CARD_PATIENTS
                + " (" + COLUMN_ID_MAP + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ID_PATIENT_MAP + " INTEGER, "
                + COLUMN_ID_DOCTOR_MAP + " INTEGER, "
                + COLUMN_DATE_MAP + " TEXT, "
                + COLUMN_DIAGNOSIS_COD_MAP + " INTEGER, "
                + COLUMN_NOTE_DOCTOR_MAP + " TEXT);");

//        insertTableScheduleDoctors(1, "14:00", "14:00", "15:00",
//                "15:00", "14:00", "16:00", "16:00");
//        myDbMethod.insertTableScheduleDoctors(1, "14:10", "14:10", "15:10",
//                "15:10", "14:10", null, null);
// insertTableDoctors(1, "Фурс Галина Федоровна", "Лор-врач",
//                "Лечение лор-заболеваний", "45 лет", "21 год", "803");
//        insertTableDoctors(2, "Фурс Галина Федоровна", "Лор-врач",
//                "Лечение лор-заболеваний", "45 лет", "21", "803");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
                "('1' , 'Фурс Галина Федоровна', 'Лор-врач', ' 45 лет', ' 21 год','Лечение лор-заболеваний', '803');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
                "('2', 'Дудко Мария Александровна', 'Лор-врач', '46 лет', '23 года', 'Лечение лор-заболеваний', '803');");
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
                "('3', 'Максимюк Анастасия Викторовна', 'Врач общей практики', '41 год', '12 лет'," +
                " 'Медпомощь на амбулаторном этапе', '451');");
//        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
//                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
//                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
//                "('4', 'Бирук Максим Сергеевич', 'Врач общей практики','23 года','2 года', " +
//                "'Медпомощь на амбулаторном этапе', '449');");
//        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
//                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
//                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
//                "('5', 'Ракоть Мария Станиславовна', 'Врач общей практики', '31 год', '6 лет', " +
//                "'Медпомощь на амбулаторном этапе', '442');");
//        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
//                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
//                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
//                "('6', 'Голик Алеся Алексеевна', 'Врач общей практики', '54 года', '32 года', " +
//                "'Медпомощь на амбулаторном этапе', '444');");
//        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
//                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
//                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
//                "('7', 'Аширов Роман Антонович', 'Врач-невролог', '40 лет', '17 лет', " +
//                "'Диагностика и лечение болезней, связанных с нервной системой', '711');");
//        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
//                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
//                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
//                "('8', 'Кочан Владимир Владимирович', 'Врач-невролог', '28 лет', '5 лет', " +
//                "'Диагностика и лечение болезней, связанных с нервной системой', '437');");
//        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
//                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
//                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
//                "('9', 'Мельникова Елена Николаевна', 'Врач-невролог', '36 лет', '13 лет', " +
//                "'Диагностика и лечение болезней, связанных с нервной системой', '711');");
//        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
//                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
//                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
//                "('10', 'Филитович Виктория Викторовна', 'Врач-невролог', '39 лет', '15 лет', " +
//                "'Диагностика и лечение болезней, связанных с нервной системой', '707');");


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


        db.execSQL("INSERT INTO " + TABLE_MEDICAL_CARD_PATIENTS + " (" + COLUMN_ID_MAP + ", " + COLUMN_ID_PATIENT_MAP
                + ", " + COLUMN_ID_DOCTOR_MAP + ", " + COLUMN_DATE_MAP
                + ", " + COLUMN_DIAGNOSIS_COD_MAP + ", " + COLUMN_NOTE_DOCTOR_MAP + ") VALUES ('1','2', '2', '26.11.2017',"
                + " '4', 'Небольшая пломба в ухе');");

        db.execSQL("INSERT INTO " + TABLE_MEDICAL_CARD_PATIENTS + " (" + COLUMN_ID_MAP + ", " + COLUMN_ID_PATIENT_MAP
                + ", " + COLUMN_ID_DOCTOR_MAP + ", " + COLUMN_DATE_MAP
                + ", " + COLUMN_DIAGNOSIS_COD_MAP + ", " + COLUMN_NOTE_DOCTOR_MAP + ") VALUES ('2','3', '1', '28.11.2017',"
                + " '3', '');");

        db.execSQL("INSERT INTO " + TABLE_MEDICAL_CARD_PATIENTS + " (" + COLUMN_ID_MAP + ", " + COLUMN_ID_PATIENT_MAP
                + ", " + COLUMN_ID_DOCTOR_MAP + ", " + COLUMN_DATE_MAP
                + ", " + COLUMN_DIAGNOSIS_COD_MAP + ", " + COLUMN_NOTE_DOCTOR_MAP + ") VALUES ('3','2', '3', '30.11.2017',"
                + " '2', 'ушшная пломба');");
    }

//    public int insertTableDoctors(int _id, String name_doctor, String spec_doctor,
//                                   String service_doctor, String age_doctor, String exp_doctor, String cab_doctor) {
//        SQLiteDatabase db = this.getWritableDatabase();
////        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
////                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
////                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
////                "('" + _id + "' , '" + name_doctor + "', '" + spec_doctor + "', '" + age_doctor + "', '" + exp_doctor + "','" + service_doctor + "', '" + cab_doctor + "');");
//    ContentValues contentValues = new ContentValues();
//    contentValues.put(COLUMN_ID_DOCTOR, _id);
//    contentValues.put(COLUMN_NAME_DOCTOR, name_doctor);
//    contentValues.put(COLUMN_SPEC_DOCTOR, spec_doctor);
//    contentValues.put(COLUMN_SERV_DOCTOR, service_doctor);
//    contentValues.put(COLUMN_AGE_DOCTOR, age_doctor);
//    contentValues.put(COLUMN_EXPER_DOCTOR, exp_doctor);
//    contentValues.put(COLUMN_CABINET_DOCTOR, cab_doctor);
//    db.insert(TABLE_DOCTORS, null, contentValues);
//    return 0;
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

//    public void insertTableScheduleDoctors(int id, String monday, String tuesday, String wednesday,
//                                           String thursday, String friday, String saturday, String sunday) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_SCHEDULE_DOCTORS_ID, id);
//        contentValues.put(COLUMN_SCHEDULE_DOCTORS_MONDAY, monday);
//        contentValues.put(COLUMN_SCHEDULE_DOCTORS_TUESDAY, tuesday);
//        contentValues.put(COLUMN_SCHEDULE_DOCTORS_WEDNESDAY, wednesday);
//        contentValues.put(COLUMN_SCHEDULE_DOCTORS_THURSDAY, thursday);
//        contentValues.put(COLUMN_SCHEDULE_DOCTORS_FRIDAY, friday);
//        contentValues.put(COLUMN_SCHEDULE_DOCTORS_SATURDAY, saturday);
//        contentValues.put(COLUMN_SCHEDULE_DOCTORS_SUNDAY, sunday);
//        db.insert(TABLE_SCHEDULE_DOCTORS, null, contentValues);
//    }

}