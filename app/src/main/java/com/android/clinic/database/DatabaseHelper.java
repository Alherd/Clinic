package com.android.clinic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "clinicBase.db";

    /**
     * Таблица TABLE_DOCTORS
     */
    public static final String TABLE_DOCTORS = "doctors"; // название таблицы в бд
    public static final String COLUMN_ID_DOCTOR = "_id_doctor";
    public static final String COLUMN_NAME_DOCTOR = "name_doctor";
    public static final String COLUMN_SPEC_DOCTOR = "spec_doctor";
    public static final String COLUMN_SERV_DOCTOR = "service_doctor";
    public static final String COLUMN_AGE_DOCTOR = "age_doctor";
    public static final String COLUMN_EXPER_DOCTOR = "experience_doctor";
    public static final String COLUMN_CABINET_DOCTOR = "cabinet_doctor";

    /**
     * Таблица TABLE_PATIENTS
     */
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

    /**
     * Таблица TABLE_SCHEDULE_DOCTORS
     */
    public static final String TABLE_SCHEDULE_DOCTORS = "schedule_doctors";
    public static final String COLUMN_SCHEDULE_ID = "_id_schedule";
    public static final String COLUMN_SCHEDULE_DOCTORS_ID = "_id_doctors";
    public static final String COLUMN_SCHEDULE_DOCTORS_DATETIME = "doctor_list_datetime";
    public static final String COLUMN_SCHEDULE_IS_ORDER = "doctor_schedule_is_order";

    /**
     * Таблица TABLE_SIGN_UP_PATIENTS
     */
    public static final String TABLE_SIGN_UP_PATIENTS = "sign_up_patients";
    public static final String COLUMN_SIGN_UP_ID = "_id_sign_up";
    public static final String COLUMN_SIGN_UP_ID_PATIENTS = "_id_patients";
    public static final String COLUMN_SIGN_UP_ID_TICKET = "_id_tickets";

    /**
     * Таблица TABLE_MEDICAL_CARD_PATIENTS
     */
    public static final String TABLE_MEDICAL_CARD_PATIENTS = "map_patients";
    public static final String COLUMN_ID_CARD = "_id_card";
    public static final String COLUMN_SIGN_ID_CARD = "_id_sign_up_card";
    public static final String COLUMN_DIAGNOSIS_COD_CARD = "diagnosis_cod_card";
    public static final String COLUMN_NOTE_DOCTOR_CARD = "note_doctor_card";

    /**
     * Таблица TABLE_DIAGNOSIS_PATIENTS
     */
    public static final String TABLE_DIAGNOSIS_PATIENTS = "diagnosis_patient";
    public static final String COLUMN_ID_DIAGNOSIS = "id_diagnosis";
    public static final String COLUMN_NAME_DIAGNOSIS = "name_diagnosis";
    public static final String COLUMN_TYPE_DIAGNOSIS = "type_diagnosis";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        /*Создание таблицы TABLE_DOCTORS*/
        db.execSQL("CREATE TABLE " + TABLE_DOCTORS
                + " (" + COLUMN_ID_DOCTOR
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME_DOCTOR + " TEXT, "
                + COLUMN_SPEC_DOCTOR + " TEXT, "
                + COLUMN_AGE_DOCTOR + " TEXT, "
                + COLUMN_EXPER_DOCTOR + " TEXT, "
                + COLUMN_SERV_DOCTOR + " TEXT, "
                + COLUMN_CABINET_DOCTOR + " TEXT);");


        /*Создание таблицы TABLE_PATIENTS*/
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


        /*Создание таблицы TABLE_SCHEDULE_DOCTORS*/
        db.execSQL("CREATE TABLE " + TABLE_SCHEDULE_DOCTORS
                + " (" + COLUMN_SCHEDULE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SCHEDULE_DOCTORS_ID + " INTEGER, "
                + COLUMN_SCHEDULE_DOCTORS_DATETIME + " DATETIME, "
                + COLUMN_SCHEDULE_IS_ORDER + " INTEGER);");


        /*Создание таблицы TABLE_SIGN_UP_PATIENTS*/
        db.execSQL("CREATE TABLE " + TABLE_SIGN_UP_PATIENTS
                + " (" + COLUMN_SIGN_UP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SIGN_UP_ID_PATIENTS + " INTEGER, "
                //  + COLUMN_SIGN_UP_ID_DOCTORS + " INTEGER, "
                + COLUMN_SIGN_UP_ID_TICKET + " INTEGER);");


        /*Создание таблицы TABLE_MEDICAL_CARD_PATIENTS*/
        db.execSQL("CREATE TABLE " + TABLE_MEDICAL_CARD_PATIENTS
                + " (" + COLUMN_ID_CARD + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SIGN_ID_CARD + " INTEGER, "
                + COLUMN_DIAGNOSIS_COD_CARD + " INTEGER, "
                + COLUMN_NOTE_DOCTOR_CARD + " TEXT);");


        /*Создание таблицы TABLE_DIAGNOSIS_PATIENTS*/
        db.execSQL("CREATE TABLE " + TABLE_DIAGNOSIS_PATIENTS
                + " (" + COLUMN_ID_DIAGNOSIS + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME_DIAGNOSIS + " TEXT, "
                + COLUMN_TYPE_DIAGNOSIS + " TEXT);");


////////////////////////////////////////////////////////////////////////////////////////////////////

        /*Заполнение таблицы TABLE_DOCTORS*/
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_AGE_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
                "('Фурс Галина Федоровна', 'Лор-врач', '45 лет', '21 год','Лечение лор-заболеваний', '803')," +
                "('Дудко Мария Александровна', 'Лор-врач', '46 лет', '23 года', 'Лечение лор-заболеваний', '803')," +
                "('Максимюк Анастасия Викторовна', 'Врач общей практики', '41 год', '12 лет', 'Медпомощь на амбулаторном этапе', '451')," +
                "('Бирук Максим Сергеевич', 'Врач общей практики', '23 года', '2 года','Медпомощь на амбулаторном этапе', '449')," +
                "('Ракоть Мария Станиславовна', 'Врач общей практики','31 год', '6 лет','Лечение лор-заболеваний', '803')," +
                "('Голик Алеся Алексеевна', 'Врач общей практики', '54 года', '32 года','Медпомощь на амбулаторном этапе', '444')," +
                "('Аширов Роман Антонович', 'Врач-невролог', '40 лет', '17 лет','Диагностика и лечение болезней, связанных с нервной системой', '711')," +
                "('Кочан Владимир Владимирович', 'Врач-невролог', '28 лет', '5 лет','Диагностика и лечение болезней, связанных с нервной системой', '437')," +
                "('Мельникова Елена Николаевна', 'Врач-невролог', '36 лет', '13 лет','Диагностика и лечение болезней, связанных с нервной системой', '711')," +
                "('Филитович Виктория Викторовна', 'Врач-невролог', '39 лет', '15 лет','Диагностика и лечение болезней, связанных с нервной системой', '707')," +
                "('Карпенко Ольга Евгениевна', 'Врач-офтальмолог', '35 лет', '11 год','Диагностика и лечение заболеваний, связанных с глазами и зрением', '814')," +
                "('Павлюченко Олег Викторович', 'Врач-офтальмолог', '44 года', '18 лет','Диагностика и лечение заболеваний, связанных с глазами и зрением', '812')," +
                "('Фадеева Ольга Юрьевна', 'Врач-офтальмолог', '25 лет', '2 года','Диагностика и лечение заболеваний, связанных с глазами и зрением', '814')," +
                "('Степанова Евгения Александровна', 'Гинеколог', '46 лет', '20 лет','Диагностика, лечение и предупреждение женских заболеваний', '209')," +
                "('Гончаревич Мария Максимовна', 'Гинеколог', '39 лет', '14 год','Диагностика, лечение и предупреждение женских заболеваний', '203')," +
                "('Борисова Дарья Алексеевна', 'Гинеколог', '41 год', '18 год','Диагностика, лечение и предупреждение женских заболеваний', '208')," +
                "('Наумов Андрей Денисович', 'Гинеколог', '43 года', '19 лет','Диагностика, лечение и предупреждение женских заболеваний', '208')," +
                "('Антонович Наталья Александровна', 'Гинеколог', '38 лет', '15 год','Диагностика, лечение и предупреждение женских заболеваний', '803')," +
                "('Бойба Денис Сергеевич', 'Хирург', '44 года', '20 год','Устранение заболеваний путём операбельного вмешательства', '149')," +
                "('Данилевич Алексей Леонидович', 'Хирург', '47 лет', '21 год','Устранение заболеваний путём операбельного вмешательства', '149')," +
                "('Василевская Алиса Валерьевна', 'Врач КПШМ', '38 лет', '13 лет','Выявление предраковых, фоновых заболеваний ШМ в период их возникновения', '707');");


        /*Заполнение таблицы TABLE_PATIENTS*/
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


        /*Заполнение таблицы TABLE_DIAGNOSIS_PATIENTS*/
        db.execSQL("INSERT INTO " + TABLE_DIAGNOSIS_PATIENTS + " (" + COLUMN_ID_DIAGNOSIS + ", "
                + COLUMN_NAME_DIAGNOSIS + ", " + COLUMN_TYPE_DIAGNOSIS + ") VALUES ('1','Абсцесс носовой перегородки',"
                + " 'ЛОР-заболевание');");
        db.execSQL("INSERT INTO " + TABLE_DIAGNOSIS_PATIENTS + " (" + COLUMN_ID_DIAGNOSIS + ", "
                + COLUMN_NAME_DIAGNOSIS + ", " + COLUMN_TYPE_DIAGNOSIS + ") VALUES ('2','Абсцесс паратонзиллярный',"
                + " 'ЛОР-заболевание');");
        db.execSQL("INSERT INTO " + TABLE_DIAGNOSIS_PATIENTS + " (" + COLUMN_ID_DIAGNOSIS + ", "
                + COLUMN_NAME_DIAGNOSIS + ", " + COLUMN_TYPE_DIAGNOSIS + ") VALUES ('3','Инфекции уха',"
                + " 'ЛОР-заболевание');");


        /*Заполнение таблицы TABLE_SCHEDULE_DOCTORS*/
        db.execSQL("INSERT INTO " + TABLE_SCHEDULE_DOCTORS + " (" + COLUMN_SCHEDULE_DOCTORS_ID
                + ", " + COLUMN_SCHEDULE_DOCTORS_DATETIME + ", " + COLUMN_SCHEDULE_IS_ORDER + ") " +
                " VALUES ('1','25 ноября 08:10','1'),('1','24 ноября 08:00','1'),('1','25 ноября 07:00','0')," +
                "('1','25 ноября 08:20','0'),('1','25 ноября 09:30','0'),('1','25 ноября 10:10','0');");


        /*Зполнение таблицы TABLE_SIGN_UP_PATIENTS*/
        db.execSQL("INSERT INTO " + TABLE_SIGN_UP_PATIENTS + " (" + COLUMN_SIGN_UP_ID + ", " + COLUMN_SIGN_UP_ID_PATIENTS
                + ", " + COLUMN_SIGN_UP_ID_TICKET + ") "
                + " VALUES ('1','2','2'),('2','2','1');");


        /*Создание таблицы TABLE_MEDICAL_CARD_PATIENTS*/
        db.execSQL("INSERT INTO " + TABLE_MEDICAL_CARD_PATIENTS + " (" + COLUMN_ID_CARD + ", " + COLUMN_SIGN_ID_CARD
                + ", " + COLUMN_DIAGNOSIS_COD_CARD + ", " + COLUMN_NOTE_DOCTOR_CARD + ") "
                + "VALUES ('1','1','1','Необходимо принять лекарство Назонекс'),('2','2','3','');");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}
