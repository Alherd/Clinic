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
    public static final String COLUMN_TIME_DOCTOR = "time_doctor";
    public static final String COLUMN_EXPER_DOCTOR = "experience_doctor";
    public static final String COLUMN_CABINET_DOCTOR = "cabinet_doctor";
    public static final String COLUMN_PHOTO_DOCTOR = "photo_doctor";

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
                + COLUMN_FNAME + " TEXT, "
                + COLUMN_LNAME + " TEXT, "
                + COLUMN_PNAME + " TEXT, "
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
        db.execSQL("INSERT INTO " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + ", " + COLUMN_NAME_DOCTOR +
                ", " + COLUMN_SPEC_DOCTOR + ", " + COLUMN_TIME_DOCTOR + ", " + COLUMN_EXPER_DOCTOR + ", " +
                COLUMN_SERV_DOCTOR + ", " + COLUMN_PHOTO_DOCTOR + ", " + COLUMN_CABINET_DOCTOR + ") VALUES " +
                "('1','Фурс Галина Федоровна', 'Лор-врач', '45 лет', '21 год','Лечение лор-заболеваний', 'res/drawable/furs.jpg', '803')," +
                "('2','Дудко Мария Александровна', 'Лор-врач', '46 лет', '23 года', 'Лечение лор-заболеваний','res/drawable/dudko.png', '803')," +
                "('3','Максимюк Анастасия Викторовна', 'Врач общей практики', '41 год', '12 лет', 'Медпомощь на амбулаторном этапе','res/drawable/maksimuk.jpg', '451')," +
                "('4','Бирук Максим Сергеевич', 'Врач общей практики', '23 года', '2 года','Медпомощь на амбулаторном этапе','res/drawable/biruk.png', '449')," +
                "('5','Ракоть Мария Станиславовна', 'Врач общей практики','31 год', '6 лет','Лечение лор-заболеваний','res/drawable/rakot.jpg', '803')," +
                "('6','Голик Алеся Алексеевна', 'Врач общей практики', '54 года', '32 года','Медпомощь на амбулаторном этапе','res/drawable/golik.jpg', '444')," +
                "('7','Аширов Роман Антонович', 'Врач-невролог', '40 лет', '17 лет','Диагностика и лечение болезней, связанных с нервной системой','res/drawable/ashirov.jpg', '711')," +
                "('8','Кочан Владимир Владимирович', 'Врач-невролог', '28 лет', '5 лет','Диагностика и лечение болезней, связанных с нервной системой','res/drawable/kochan.jpg', '437')," +
                "('9','Мельникова Елена Николаевна', 'Врач-невролог', '36 лет', '13 лет','Диагностика и лечение болезней, связанных с нервной системой','res/drawable/melnikova.jpg', '711')," +
                "('10','Филитович Виктория Викторовна', 'Врач-невролог', '29 лет', '5 лет','Диагностика и лечение болезней, связанных с нервной системой','res/drawable/filitovich.jpg','707')," +
                "('11','Карпенко Ольга Евгениевна', 'Врач-офтальмолог', '35 лет', '11 год','Диагностика и лечение заболеваний, связанных с глазами и зрением','res/drawable/karpenko.jpg', '814')," +
                "('12','Павлюченко Олег Викторович', 'Врач-офтальмолог', '44 года', '18 лет','Диагностика и лечение заболеваний, связанных с глазами и зрением','res/drawable/pavluchenko.jpg', '812')," +
                "('13','Фадеева Ольга Юрьевна', 'Врач-офтальмолог', '25 лет', '2 года','Диагностика и лечение заболеваний, связанных с глазами и зрением','res/drawable/fadeeva.jpg', '814')," +
                "('14','Степанова Евгения Александровна', 'Гинеколог', '46 лет', '20 лет','Диагностика, лечение и предупреждение женских заболеваний','res/drawable/stepanova.jpg', '209')," +
                "('15','Гончаревич Мария Максимовна', 'Гинеколог', '39 лет', '14 год','Диагностика, лечение и предупреждение женских заболеваний','res/drawable/goncharevich.jpg', '203')," +
                "('16','Борисова Дарья Алексеевна', 'Гинеколог', '49 лет', '27 лет','Диагностика, лечение и предупреждение женских заболеваний','res/drawable/borisova.jpg', '208')," +
                "('17','Наумов Андрей Денисович', 'Гинеколог', '43 года', '19 лет','Диагностика, лечение и предупреждение женских заболеваний','res/drawable/naumov.jpg', '208')," +
                "('18','Антонович Наталья Александровна', 'Гинеколог', '31 лет', '4 года','Диагностика, лечение и предупреждение женских заболеваний','res/drawable/antonovich.jpg', '803')," +
                "('19','Бойба Денис Сергеевич', 'Хирург', '44 года', '20 год','Устранение заболеваний путём операбельного вмешательства','res/drawable/bojba.jpg', '149')," +
                "('20','Данилевич Алексей Леонидович', 'Хирург', '47 лет', '21 год','Устранение заболеваний путём операбельного вмешательства','res/drawable/danilevich.jpg', '149')," +
                "('21','Кривоносова Анастасия Владимировна', 'Терапевт', '36 лет', '11 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/krivonosova.jpg', '441')," +
                "('22','Ярмолик Лариса Леонидовна', 'Терапевт', '32 года', '10 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/jarmolik.jpg', '439')," +
                "('23','Лапытько Александр Иванович', 'Терапевт', '38 лет', '16 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/lapytko.jpg', '443')," +
                "('24','Юргенс Юрий Григорьевич', 'Терапевт', '31 год', '6 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/jurgens.jpg', '445')," +
                "('25','Козловская Татьяна Алексеевна', 'Терапевт', '33 года', '9 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/kozlovskaja.jpg', '440')," +
                "('26','Калитуха Василиса Владиславовна', 'Терапевт', '37 лет', '14 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/kalituha.jpg', '432')," +
                "('27','Боровская Евгения Олеговна', 'Терапевт', '42 года', '17 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/borovskaja.jpg', '438')," +
                "('28','Ломов Владимир Юрьевич', 'Терапевт', '43 года', '18 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/lomov.jpg', '434')," +
                "('29','Пышинская Виктория Леонтьевна', 'Терапевт', '40 лет', '16 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/pyshinskaja.jpg', '438')," +
                "('30','Солоникова Мария Викторовна', 'Терапевт', '39 лет', '16 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/solonikova.jpg', '447')," +
                "('31','Хилькевич Константин Сергеевич', 'Терапевт', '37 лет', '14 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/hilkevich.jpg', '445')," +
                "('32','Романец Александра Сергеевна', 'Терапевт', '35 лет', '13 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/romanets.jpg', '443')," +
                "('33','Денисеня Денис Сергеевич', 'Терапевт', '35 лет', '13 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/denisenya.jpg', '434')," +
                "('34','Наймович Екатерина Николаевна', 'Терапевт', '44 года', '20 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/najmovich.jpg', '439')," +
                "('35','Царенок Максим Сергеевич', 'Терапевт', '41 год', '19 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/tsarenok.jpg', '436')," +
                "('36','Резник Константин Сильвестрович', 'Терапевт', '28 лет', '6 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/reznik.jpg', '441')," +
                "('37','Богданович Дарья Георгиевна', 'Терапевт', '32 года', '10 лет','Лечение простуды и респираторно-вирусных инфекций: гриппа, ОРЗ, насморк и др.','res/drawable/bogdanovich.jpg', '432')," +
                "('38','Василевская Алиса Валерьевна', 'Врач КПШМ', '38 лет', '13 лет','Выявление предраковых, фоновых заболеваний ШМ в период их возникновения','res/drawable/vasilevskaja.jpg', '707');");


        /*Заполнение таблицы TABLE_PATIENTS*/
        db.execSQL("INSERT INTO " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT + ", " + COLUMN_LOGIN_PATIENT
                + ", " + COLUMN_PASSWORD_PATIENT + ", " + COLUMN_FNAME
                + ", " + COLUMN_LNAME + ", " + COLUMN_PNAME + /*", " + COLUMN_BIRTH +*/ ", "
                + COLUMN_ADDRESS + ", " + COLUMN_EMAIL + ") VALUES ('1', 'angelina', '111', 'Ангелина', 'Бобришёва', " +
                "'Николаевна','ул. Неманская 25, 51', 'angelina@gmail.com');");
        db.execSQL("INSERT INTO " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT + ", " + COLUMN_LOGIN_PATIENT
                + ", " + COLUMN_PASSWORD_PATIENT + ", " + COLUMN_FNAME
                + ", " + COLUMN_LNAME + ", " + COLUMN_PNAME + ", "
                + COLUMN_ADDRESS + ", " + COLUMN_EMAIL + ") VALUES ('2', 'pavel', '222', 'Павел', 'Жданович'," +
                " 'Константинович','ул. Колесникова 8,23', 'pavel@tut.by');");
        db.execSQL("INSERT INTO " + TABLE_PATIENTS + " (" + COLUMN_ID_PATIENT + ", " + COLUMN_LOGIN_PATIENT
                + ", " + COLUMN_PASSWORD_PATIENT + ", " + COLUMN_FNAME
                + ", " + COLUMN_LNAME + ", " + COLUMN_PNAME + ", "
                + COLUMN_ADDRESS + ", " + COLUMN_EMAIL + ") VALUES ('3','victoria', '333', 'Виктория', 'Левчук'," +
                " 'Александровна','ул. Налибоцкая 3,14', 'vika@rambler.ru');");


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
                + ", " + COLUMN_SIGN_UP_ID_TICKET + ") " + " VALUES ('1','2','11'),('2','2','1'), ('3','2','20'),('4','3','3');");


        /*Создание таблицы TABLE_MEDICAL_CARD_PATIENTS*/
        db.execSQL("INSERT INTO " + TABLE_MEDICAL_CARD_PATIENTS + " (" + COLUMN_ID_CARD + ", " + COLUMN_SIGN_ID_CARD
                + ", " + COLUMN_DIAGNOSIS_COD_CARD + ", " + COLUMN_NOTE_DOCTOR_CARD + ") "
                + "VALUES ('1','1','1','Необходимо принять лекарство Назонекс'),('2','2','3',''), ('3','3','2','');");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}
