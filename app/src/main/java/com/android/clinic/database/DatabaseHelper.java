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
    public static final String COLUMN_LOGIN_DOCTOR = "login_doctor";
    public static final String COLUMN_PASSWORD_DOCTOR = "password_doctor";
    public static final String COLUMN_NAME_DOCTOR = "name_doctor";
    public static final String COLUMN_SPEC_DOCTOR = "spec_doctor";
    public static final String COLUMN_SERV_DOCTOR = "service_doctor";
    public static final String COLUMN_TIME_DOCTOR = "time_doctor";
    public static final String COLUMN_EXPER_DOCTOR = "experience_doctor";
    public static final String COLUMN_CABINET_DOCTOR = "cabinet_doctor";
    public static final String COLUMN_PHOTO_DOCTOR = "photo_doctor";

    /**
     * Таблица TABLE_PATIENTS
     */
    public static final String TABLE_PATIENTS = "patients"; // название таблицы в бд
    public static final String COLUMN_ID_PATIENT = "_id_patient";
    public static final String COLUMN_LOGIN_PATIENT = "login_patient";
    public static final String COLUMN_PASSWORD_PATIENT = "password_patient";
    public static final String COLUMN_FNAME_PATIENT = "fname_patient";
    public static final String COLUMN_LNAME = "lname_patient";
    public static final String COLUMN_PNAME = "patronymic_patient";
    public static final String COLUMN_ADDRESS = "address_patient";
    public static final String COLUMN_PHONE = "phone_patient";

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
    public static final String COLUMN_SIGN_UP_IS_OVER = "_is_over";

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
    public static final String COLUMN_ID_DIAGNOSIS = "_id_diagnosis";
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
                + COLUMN_LOGIN_DOCTOR + " TEXT, "
                + COLUMN_PASSWORD_DOCTOR + " TEXT, "
                + COLUMN_NAME_DOCTOR + " TEXT, "
                + COLUMN_SPEC_DOCTOR + " TEXT, "
                + COLUMN_TIME_DOCTOR + " TEXT, "
                + COLUMN_EXPER_DOCTOR + " TEXT, "
                + COLUMN_SERV_DOCTOR + " TEXT, "
                + COLUMN_PHOTO_DOCTOR + " TEXT, "
                + COLUMN_CABINET_DOCTOR + " TEXT);");


        /*Создание таблицы TABLE_PATIENTS*/
        db.execSQL("CREATE TABLE " + TABLE_PATIENTS
                + " (" + COLUMN_ID_PATIENT
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_LOGIN_PATIENT + " TEXT, "
                + COLUMN_PASSWORD_PATIENT + " TEXT, "
                + COLUMN_FNAME_PATIENT + " TEXT, "
                + COLUMN_LNAME + " TEXT, "
                + COLUMN_PNAME + " TEXT, "
                + COLUMN_ADDRESS + " TEXT, "
                + COLUMN_PHONE + " TEXT);");


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
                + COLUMN_SIGN_UP_ID_TICKET + " INTEGER, "
                + COLUMN_SIGN_UP_IS_OVER + " INTEGER);");


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
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_LOGIN_DOCTOR +
                ", " + COLUMN_PASSWORD_DOCTOR + ", " + COLUMN_NAME_DOCTOR + ", " + COLUMN_SPEC_DOCTOR +
                ", " + COLUMN_TIME_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " + COLUMN_SERV_DOCTOR +
                ", " + COLUMN_PHOTO_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
                "('1','furs','1803','Фурс Галина Федоровна', 'Лор-врач', '45 лет', '21 год','Лечение лор-заболеваний', 'res/drawable/furs.jpg', '803')," +
                "('2','dudko','2803','Дудко Мария Александровна', 'Лор-врач', '46 лет', '23 года', 'Лечение лор-заболеваний','res/drawable/dudko.png', '803')," +
                "('3','maks','3451','Максимюк Анастасия Викторовна', 'Врач общей практики', '41 год', '12 лет', 'Медпомощь на амбулаторном этапе','res/drawable/maksimuk.jpg', '451')," +
                "('4','biruk','4449','Бирук Максим Сергеевич', 'Врач общей практики', '23 года', '2 года','Медпомощь на амбулаторном этапе','res/drawable/biruk.png', '449')," +
                "('5','rakot','5803','Ракоть Мария Станиславовна', 'Врач общей практики','31 год', '6 лет','Лечение лор-заболеваний','res/drawable/rakot.jpg', '803')," +
                "('6','golik','6444','Голик Алеся Алексеевна', 'Врач общей практики', '54 года', '32 года','Медпомощь на амбулаторном этапе','res/drawable/golik.jpg', '444')," +
                "('7','ashirov','7711','Аширов Роман Антонович', 'Врач-невролог', '40 лет', '17 лет','Неврология','res/drawable/ashirov.jpg', '711')," +
                "('8','kochan','8437','Кочан Владимир Владимирович', 'Врач-невролог', '28 лет', '5 лет','Неврология','res/drawable/kochan.jpg', '437')," +
                "('9','melnikova','9711','Мельникова Елена Николаевна', 'Врач-невролог', '36 лет', '13 лет','Неврология','res/drawable/melnikova.jpg', '711')," +
                "('10','filitovich','10707','Филитович Виктория Викторовна', 'Врач-невролог', '29 лет', '5 лет','Неврология','res/drawable/filitovich.jpg','707')," +
                "('11','karpenko','11814','Карпенко Ольга Евгениевна', 'Врач-офтальмолог', '35 лет', '11 год','Офтальмология','res/drawable/karpenko.jpg', '814')," +
                "('12','pavluchenko','12812','Павлюченко Олег Викторович', 'Врач-офтальмолог', '44 года', '18 лет','Офтальмология','res/drawable/pavluchenko.jpg', '812')," +
                "('13','fadeeva','13814','Фадеева Ольга Юрьевна', 'Врач-офтальмолог', '25 лет', '2 года','Офтальмология','res/drawable/fadeeva.jpg', '814')," +
                "('14','stepanova','14209','Степанова Евгения Александровна', 'Гинеколог', '46 лет', '20 лет','Гинекология','res/drawable/stepanova.jpg', '209')," +
                "('15','goncharevich','15203','Гончаревич Мария Максимовна', 'Гинеколог', '39 лет', '14 год','Гинекология','res/drawable/goncharevich.jpg', '203')," +
                "('16','borisova','16208','Борисова Дарья Алексеевна', 'Гинеколог', '49 лет', '27 лет','Гинекология','res/drawable/borisova.jpg', '208')," +
                "('17','naumov','17208','Наумов Андрей Денисович', 'Гинеколог', '43 года', '19 лет','Гинекология','res/drawable/naumov.jpg', '208')," +
                "('18','antonovich','18203','Антонович Наталья Александровна', 'Гинеколог', '31 лет', '4 года','Гинекология','res/drawable/antonovich.jpg', '203')," +
                "('19','bojba','19149','Бойба Денис Сергеевич', 'Хирург', '44 года', '20 год','Хирургия','res/drawable/bojba.jpg', '149')," +
                "('20','danilevich','20149','Данилевич Алексей Леонидович', 'Хирург', '47 лет', '21 год','Хирургия','res/drawable/danilevich.jpg', '149')," +
                "('21','krivonosova','21441','Кривоносова Анастасия Владимировна', 'Терапевт', '36 лет', '11 лет','Терапевтия','res/drawable/krivonosova.jpg', '441')," +
                "('22','jarmolik','22439','Ярмолик Лариса Леонидовна', 'Терапевт', '32 года', '10 лет','Терапевтия','res/drawable/jarmolik.jpg', '439')," +
                "('23','lapytko','23443','Лапытько Александр Иванович', 'Терапевт', '38 лет', '16 лет','Терапевтия','res/drawable/lapytko.jpg', '443')," +
                "('24','jurgens','24445','Юргенс Юрий Григорьевич', 'Терапевт', '31 год', '6 лет','Терапевтия','res/drawable/jurgens.jpg', '445')," +
                "('25','kozlovskaja','25440','Козловская Татьяна Алексеевна', 'Терапевт', '33 года', '9 лет','Терапевтия','res/drawable/kozlovskaja.jpg', '440')," +
                "('26','kalituha','26432','Калитуха Василиса Владиславовна', 'Терапевт', '37 лет', '14 лет','Терапевтия','res/drawable/kalituha.jpg', '432')," +
                "('27','borovskaja','27438','Боровская Евгения Олеговна', 'Терапевт', '42 года', '17 лет','Терапевтия','res/drawable/borovskaja.jpg', '438')," +
                "('28','lomov','28434','Ломов Владимир Юрьевич', 'Терапевт', '43 года', '18 лет','Терапевтия','res/drawable/lomov.jpg', '434')," +
                "('29','pyshinskaja','29438','Пышинская Виктория Леонтьевна', 'Терапевт', '40 лет', '16 лет','Терапевтия','res/drawable/pyshinskaja.jpg', '438')," +
                "('30','solonikova','30447','Солоникова Мария Викторовна', 'Терапевт', '39 лет', '16 лет','Терапевтия','res/drawable/solonikova.jpg', '447')," +
                "('31','hilkevich','31445','Хилькевич Константин Сергеевич', 'Терапевт', '37 лет', '14 лет','Терапевтия','res/drawable/hilkevich.jpg', '445')," +
                "('32','romanets','32443','Романец Александра Сергеевна', 'Терапевт', '35 лет', '13 лет','Терапевтия','res/drawable/romanets.jpg', '443')," +
                "('33','denisenya','33434','Денисеня Денис Сергеевич', 'Терапевт', '35 лет', '13 лет','Терапевтия','res/drawable/denisenya.jpg', '434')," +
                "('34','najmovich','34439','Наймович Екатерина Николаевна', 'Терапевт', '44 года', '20 лет','Терапевтия','res/drawable/najmovich.jpg', '439')," +
                "('35','tsarenok','35436','Царенок Максим Сергеевич', 'Терапевт', '41 год', '19 лет','Терапевтия','res/drawable/tsarenok.jpg', '436')," +
                "('36','reznik','36441','Резник Константин Сильвестрович', 'Терапевт', '28 лет', '6 лет','Терапевтия','res/drawable/reznik.jpg', '441')," +
                "('37','bogdanovich','37432','Богданович Дарья Георгиевна', 'Терапевт', '32 года', '10 лет','Терапевтия','res/drawable/bogdanovich.jpg', '432')," +
                "('38','vasilevckaja','38707','Василевская Алиса Валерьевна', 'Врач КПШМ', '38 лет', '13 лет','Выявление предраковых, фоновых заболеваний ШМ в период их возникновения','res/drawable/vasilevskaja.jpg', '707');");


        /*Заполнение таблицы TABLE_PATIENTS*/
        db.execSQL("INSERT INTO " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT + ", " + COLUMN_LOGIN_PATIENT
                + ", " + COLUMN_PASSWORD_PATIENT + ", " + COLUMN_FNAME_PATIENT
                + ", " + COLUMN_LNAME + ", " + COLUMN_PNAME + /*", " + COLUMN_BIRTH +*/ ", "
                + COLUMN_ADDRESS + ", " + COLUMN_PHONE + ") VALUES ('101', 'angelina', '111', 'Ангелина', 'Бобришёва', " +
                "'Николаевна','ул. Неманская 25, 51', '+375448107253');");
        db.execSQL("INSERT INTO " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT + ", " + COLUMN_LOGIN_PATIENT
                + ", " + COLUMN_PASSWORD_PATIENT + ", " + COLUMN_FNAME_PATIENT
                + ", " + COLUMN_LNAME + ", " + COLUMN_PNAME + ", "
                + COLUMN_ADDRESS + ", " + COLUMN_PHONE + ") VALUES ('102', 'pavel', '222', 'Павел', 'Жданович'," +
                " 'Константинович','ул. Колесникова 8,23', '+375294671197');");
        db.execSQL("INSERT INTO " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT + ", " + COLUMN_LOGIN_PATIENT
                + ", " + COLUMN_PASSWORD_PATIENT + ", " + COLUMN_FNAME_PATIENT
                + ", " + COLUMN_LNAME + ", " + COLUMN_PNAME + ", "
                + COLUMN_ADDRESS + ", " + COLUMN_PHONE + ") VALUES ('103','victoria', '333', 'Виктория', 'Левчук'," +
                " 'Александровна','ул. Налибоцкая 3,14', '+375256113492');");


        /*Заполнение таблицы TABLE_DIAGNOSIS_PATIENTS*/
        db.execSQL("INSERT INTO " + TABLE_DIAGNOSIS_PATIENTS + " (" + COLUMN_NAME_DIAGNOSIS + ", " +
                COLUMN_TYPE_DIAGNOSIS + ") VALUES ('Абсцесс носовой перегородки','ЛОР-заболевание')," +
                "('Абсцесс паратонзиллярный','ЛОР-заболевание'),('Инфекции уха','ЛОР-заболевание')," +
                "('Акромегалия','Нейроэндокринное заболевание'),('Акромегалия','Нейроэндокринное заболевание')," +
                "('Актиномикоз','Экзогенная инфекция'),('Ангина','Стрептококковая инфекция');");

//http://www.eurolab.ua/diseases/%D0%93/
        /*Заполнение таблицы TABLE_SCHEDULE_DOCTORS*/
        db.execSQL("INSERT INTO " + TABLE_SCHEDULE_DOCTORS + " (" + COLUMN_SCHEDULE_DOCTORS_ID
                + ", " + COLUMN_SCHEDULE_DOCTORS_DATETIME + ", " + COLUMN_SCHEDULE_IS_ORDER + ") " +
                " VALUES ('1','25 ноября 08:10','1'),('1','24 ноября 08:00','0'),('1','25 ноября 07:00','1')," +
                "('1','25 ноября 08:20','0'),('1','25 ноября 09:30','0'),('1','25 ноября 10:10','0')" +
                ",('1','25 ноября 10:50','0'),('1','26 ноября 11:10','0'),('1','26 ноября 11:40','0')" +
                ",('2','25 ноября 08:10','0'),('2','25 ноября 08:40','1'),('2','25 ноября 09:30','0')" +
                ",('2','25 ноября 10:00','0'),('2','25 ноября 10:40','0'),('2','26 ноября 11:10','0')" +
                ",('2','26 ноября 10:10','0'),('2','27 ноября 09:00','0'),('2','28 ноября 08:20','0')" +
                ",('2','29 ноября 09:50','0'),('3','25 ноября 09:10','1'),('3','25 ноября 11:40','0')" +
                ",('3','26 ноября 08:10','0'),('3','26 ноября 10:20','0'),('3','27 ноября 08:10','0')" +
                ",('3','28 ноября 08:50','0'),('4','25 ноября 09:40','0'),('4','26 ноября 10:50','0')" +
                ",('4','27 ноября 09:10','0'),('4','28 ноября 08:00','0'),('4','25 ноября 10:40','0')" +
                ",('5','25 ноября 10:30','0'),('5','26 ноября 10:10','0'),('5','27 ноября 11:10','0')" +
                ",('5','28 ноября 09:10','0'),('5','28 ноября 10:40','0'),('5','28 ноября 11:50','0')" +
                ",('6','27 ноября 09:10','0'),('6','27 ноября 17:20','0'),('6','28 ноября 11:40','0')" +
                ",('7','28 ноября 10:50','0'),('7','28 ноября 11:00','0'),('8','26 ноября 18:40','0')" +
                ",('8','28 ноября 19:10','0'),('9','25 ноября 11:00','0'),('9','26 ноября 10:10','0')" +
                ",('9','28 ноября 11:40','0'),('10','25 ноября 10:10','0'),('10','26 ноября 10:30','0')" +
                ",('10','27 ноября 09:10','0'),('11','27 ноября 16:40','0'),('11','28 ноября 17:00','0')" +
                ",('12','25 ноября 11:00','0'),('12','25 ноября 11:30','0'),('12','27 ноября 10:10','0')" +
                ",('12','28 ноября 11:40','0'),('13','27 ноября 10:50','0'),('13','28 ноября 16:10','0')" +
                ",('13','28 ноября 12:40','0'),('14','25 ноября 18:10','0'),('14','25 ноября 17:20','0')" +
                ",('14','26 ноября 19:10','0'),('14','27 ноября 18:50','0'),('14','28 ноября 16:30','0')" +
                ",('15','25 ноября 09:20','0'),('15','27 ноября 11:50','0'),('15','28 ноября 11:30','0')" +
                ",('16','27 ноября 11:10','0'),('16','27 ноября 12:10','0'),('16','27 ноября 12:30','0')" +
                ",('17','26 ноября 11:10','0'),('17','27 ноября 12:00','0'),('17','28 ноября 08:10','0')" +
                ",('17','28 ноября 11:40','0'),('17','28 ноября 11:50','0'),('17','28 ноября 12:10','0')" +
                ",('18','25 ноября 11:50','0'),('18','27 ноября 12:50','0'),('19','27 ноября 15:30','0')" +
                ",('19','27 ноября 15:10','0'),('19','27 ноября 16:40','0'),('19','27 ноября 17:10','0')" +
                ",('20','27 ноября 19:10','0'),('20','28 ноября 16:50','0'),('21','26 ноября 09:10','0')" +
                ",('21','26 ноября 09:10','0'),('21','28 ноября 10:40','0'),('22','25 ноября 11:40','0')" +
                ",('22','27 ноября 11:10','0'),('22','27 ноября 12:10','0'),('22','28 ноября 08:00','0')" +
                ",('23','26 ноября 10:30','0'),('23','28 ноября 12:20','0'),('24','26 ноября 18:00','0')" +
                ",('24','27 ноября 17:10','0'),('25','26 ноября 11:20','0'),('25','28 ноября 08:20','0')" +
                ",('26','26 ноября 09:10','0'),('26','27 ноября 12:10','0'),('26','27 ноября 12:30','0')" +
                ",('27','27 ноября 14:10','0'),('27','27 ноября 16:30','0'),('27','27 ноября 16:40','0')" +
                ",('28','25 ноября 09:10','0'),('28','27 ноября 12:10','0'),('29','27 ноября 10:00','0')" +
                ",('29','28 ноября 09:00','0'),('29','28 ноября 10:20','0'),('29','28 ноября 11:00','0')" +
                ",('30','25 ноября 17:30','0'),('30','28 ноября 11:10','0'),('31','26 ноября 11:40','0')" +
                ",('31','28 ноября 09:00','0'),('31','28 ноября 10:30','0'),('31','28 ноября 11:20','0')" +
                ",('32','27 ноября 16:20','0'),('32','27 ноября 17:10','0'),('32','28 ноября 15:20','0')" +
                ",('32','28 ноября 15:50','0'),('32','28 ноября 17:40','0'),('33','26 ноября 15:00','0')" +
                ",('33','27 ноября 16:10','0'),('33','27 ноября 18:10','0'),('33','28 ноября 15:40','0')" +
                ",('34','26 ноября 10:30','0'),('34','27 ноября 09:20','0'),('34','27 ноября 11:00','0')" +
                ",('35','27 ноября 16:10','0'),('35','27 ноября 16:20','0'),('35','27 ноября 17:10','0')" +
                ",('35','28 ноября 16:00','0'),('35','28 ноября 16:40','0'),('35','28 ноября 17:20','0')" +
                ",('36','25 ноября 09:10','0'),('36','26 ноября 11:20','0'),('36','28 ноября 10:00','0')" +
                ",('37','27 ноября 10:10','0'),('37','28 ноября 08:40','0'),('37','28 ноября 10:10','0')" +
                ",('38','25 ноября 18:10','0'),('38','28 ноября 15:10','0'),('38','28 ноября 16:50','0');");


        /*Зполнение таблицы TABLE_SIGN_UP_PATIENTS*/
        db.execSQL("INSERT INTO " + TABLE_SIGN_UP_PATIENTS + " (" + COLUMN_SIGN_UP_ID + ", " + COLUMN_SIGN_UP_ID_PATIENTS
                + ", " + COLUMN_SIGN_UP_ID_TICKET + ", " + COLUMN_SIGN_UP_IS_OVER + ") " + " VALUES ('1','102','11','1'),('2','102','1','1'), ('3','102','20','1'),('4','103','3','0');");


        /*Создание таблицы TABLE_MEDICAL_CARD_PATIENTS*/
        db.execSQL("INSERT INTO " + TABLE_MEDICAL_CARD_PATIENTS + " (" + COLUMN_SIGN_ID_CARD
                + ", " + COLUMN_DIAGNOSIS_COD_CARD + ", " + COLUMN_NOTE_DOCTOR_CARD + ") "
                + "VALUES ('1','1','Необходимо принять лекарство Назонекс'),('2','3',''), ('3','2','');");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}
