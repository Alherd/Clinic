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
    public static final String COLUMN_SCHEDULE_ID = "_id2";
    public static final String COLUMN_SCHEDULE_DOCTORS_ID = "_id_doctor";
    public static final String COLUMN_SCHEDULE_DOCTORS_DATETIME = "doctor_list_datetime";
    public static final String COLUMN_SCHEDULE_IS_ORDER = "doctor_schedule_is_order";

    public static final String TABLE_SIGN_UP_PATIENTS = "sign_up_patients";
    public static final String COLUMN_SIGN_UP_ID = "_id1";
    public static final String COLUMN_SIGN_UP_ID_PATIENTS = "_id_patients";
    // public static final String COLUMN_SIGN_UP_ID_DOCTORS = "_id_doctors";
    public static final String COLUMN_SIGN_UP_ID_TICKET = "_id_tickets";

    public static final String TABLE_MEDICAL_CARD_PATIENTS = "map_patients";
    public static final String COLUMN_ID_MAP = "_id_map";
    public static final String COLUMN_ID_PATIENT_MAP = "id_patient";
    public static final String COLUMN_ID_DOCTOR_MAP = "id_doctor";
    public static final String COLUMN_DATE_MAP = "date_map";
    public static final String COLUMN_DIAGNOSIS_COD_MAP = "diagnosis_cod_map";
    public static final String COLUMN_NOTE_DOCTOR_MAP = "note_doctor_map";

    public static final String TABLE_DIAGNOSIS_PATIENTS = "diagnosis_patient";
    public static final String COLUMN_ID_DIAGNOSIS = "id_diagnosis";
    public static final String COLUMN_NAME_DIAGNOSIS = "name_diagnosis";
    public static final String COLUMN_TYPE_DIAGNOSIS = "type_diagnosis";


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
                + " (" + COLUMN_SCHEDULE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SCHEDULE_DOCTORS_ID + " INTEGER, "
                + COLUMN_SCHEDULE_DOCTORS_DATETIME + " DATETIME, "
                + COLUMN_SCHEDULE_IS_ORDER + " INTEGER);");


        db.execSQL("CREATE TABLE " + TABLE_SIGN_UP_PATIENTS
                + " (" + COLUMN_SIGN_UP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SIGN_UP_ID_PATIENTS + " INTEGER, "
                //  + COLUMN_SIGN_UP_ID_DOCTORS + " INTEGER, "
                + COLUMN_SIGN_UP_ID_TICKET + " INTEGER);");


        db.execSQL("CREATE TABLE " + TABLE_MEDICAL_CARD_PATIENTS
                + " (" + COLUMN_ID_MAP + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ID_PATIENT_MAP + " INTEGER, "
                + COLUMN_ID_DOCTOR_MAP + " INTEGER, "
                + COLUMN_DATE_MAP + " TEXT, "
                + COLUMN_DIAGNOSIS_COD_MAP + " INTEGER, "
                + COLUMN_NOTE_DOCTOR_MAP + " TEXT);");


        db.execSQL("CREATE TABLE " + TABLE_DIAGNOSIS_PATIENTS
                + " (" + COLUMN_ID_DIAGNOSIS + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME_DIAGNOSIS + " TEXT, "
                + COLUMN_TYPE_DIAGNOSIS + " TEXT);");


        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
                "('1' , 'Фурс Галина Федоровна', 'Лор-врач', ' 45 лет', ' 21 год','Лечение лор-заболеваний', '803')," +
                "('2', 'Дудко Мария Александровна', 'Лор-врач', '46 лет', '23 года', 'Лечение лор-заболеваний', '803')," +
                "('3', 'Максимюк Анастасия Викторовна', 'Врач общей практики', '41 год', '12 лет', 'Медпомощь на амбулаторном этапе', '451');");
//        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
//                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
//                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
//                "('2', 'Дудко Мария Александровна', 'Лор-врач', '46 лет', '23 года', 'Лечение лор-заболеваний', '803');");
//        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
//                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
//                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
//                "('3', 'Максимюк Анастасия Викторовна', 'Врач общей практики', '41 год', '12 лет'," +
//                " 'Медпомощь на амбулаторном этапе', '451');");
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


        db.execSQL("INSERT INTO " + TABLE_DIAGNOSIS_PATIENTS + " (" + COLUMN_ID_DIAGNOSIS + ", "
                + COLUMN_NAME_DIAGNOSIS + ", " + COLUMN_TYPE_DIAGNOSIS + ") VALUES ('1','Абсцесс носовой перегородки',"
                + " 'ЛОР-заболевание');");
        db.execSQL("INSERT INTO " + TABLE_DIAGNOSIS_PATIENTS + " (" + COLUMN_ID_DIAGNOSIS + ", "
                + COLUMN_NAME_DIAGNOSIS + ", " + COLUMN_TYPE_DIAGNOSIS + ") VALUES ('2','Абсцесс паратонзиллярный',"
                + " 'ЛОР-заболевание');");
        db.execSQL("INSERT INTO " + TABLE_DIAGNOSIS_PATIENTS + " (" + COLUMN_ID_DIAGNOSIS + ", "
                + COLUMN_NAME_DIAGNOSIS + ", " + COLUMN_TYPE_DIAGNOSIS + ") VALUES ('3','Инфекции уха',"
                + " 'ЛОР-заболевание');");


        db.execSQL("INSERT INTO " + TABLE_SCHEDULE_DOCTORS + " (" + COLUMN_SCHEDULE_ID + ", " + COLUMN_SCHEDULE_DOCTORS_ID
                + ", " + COLUMN_SCHEDULE_DOCTORS_DATETIME + ", " + COLUMN_SCHEDULE_IS_ORDER + ") " +
                "VALUES ('1','1','24 ноября 08:00','0'),('2','1','25 ноября 08:10','0')" + ",('3','1','25 ноября 07:00','0');");


        db.execSQL("INSERT INTO " + TABLE_SIGN_UP_PATIENTS + " (" + COLUMN_SIGN_UP_ID + ", " + COLUMN_SIGN_UP_ID_PATIENTS
                + ", " + COLUMN_SIGN_UP_ID_TICKET + ") "
                + " VALUES ('1','2','2');");


        db.execSQL("INSERT INTO " + TABLE_MEDICAL_CARD_PATIENTS + " (" + COLUMN_ID_MAP + ", " + COLUMN_ID_PATIENT_MAP
                + ", " + COLUMN_ID_DOCTOR_MAP + ", " + COLUMN_DATE_MAP
                + ", " + COLUMN_DIAGNOSIS_COD_MAP + ", " + COLUMN_NOTE_DOCTOR_MAP + ") VALUES ('1','2', '2', '26.11.2017',"
                + " '1', 'Небольшая пломба в ухе');");
        db.execSQL("INSERT INTO " + TABLE_MEDICAL_CARD_PATIENTS + " (" + COLUMN_ID_MAP + ", " + COLUMN_ID_PATIENT_MAP
                + ", " + COLUMN_ID_DOCTOR_MAP + ", " + COLUMN_DATE_MAP
                + ", " + COLUMN_DIAGNOSIS_COD_MAP + ", " + COLUMN_NOTE_DOCTOR_MAP + ") VALUES ('2','3', '1', '28.11.2017',"
                + " '3', 'нет');");
        db.execSQL("INSERT INTO " + TABLE_MEDICAL_CARD_PATIENTS + " (" + COLUMN_ID_MAP + ", " + COLUMN_ID_PATIENT_MAP
                + ", " + COLUMN_ID_DOCTOR_MAP + ", " + COLUMN_DATE_MAP
                + ", " + COLUMN_DIAGNOSIS_COD_MAP + ", " + COLUMN_NOTE_DOCTOR_MAP + ") VALUES ('3','2', '3', '30.11.2017',"
                + " '2', 'ушная пломба');");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}
