package com.example.enigma;

public class konfigurasi {
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD_MHS="http://192.168.18.8/Enigma/database/addMaha.php";
    public static final String URL_LOGIN_MHS="http://192.168.18.8/Enigma/database/loginMaha.php";
    public static final String URL_ADD_DSN="http://192.168.18.8/Enigma/database/addDosen.php";
    public static final String URL_LOGIN_DSN="http://192.168.18.8/Enigma/database/loginDosen.php";
    public static final String URL_Absen="http://192.168.18.8/Enigma/database/Absen.php";
    public static final String URL_GETDATA_DSN="http://192.168.18.8/Enigma/database/dataDosen.php";
    public static final String URL_Qr_nim="http://192.168.18.8/Enigma/database/temp/";
    public static final String URL_List_Kehadiran="http://192.168.18.8/Enigma/database/listHadir.php/";
    public static final String URL_List_Kelas="http://192.168.18.8/Enigma/database/listKelas.php/";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    //mahasiswa
    public static final String KEY_maha_ID = "id";
    public static final String KEY_maha_NIM = "nim";
    public static final String KEY_maha_NAMA = "nama";
    public static final String KEY_maha_EMAIL = "email";
    public static final String KEY_maha_PASS = "pass";
    //dosen
    public static final String KEY_dsn_ID = "id";
    public static final String KEY_dsn_NIP = "nip";
    public static final String KEY_dsn_NAMA = "nama";
    public static final String KEY_dsn_EMAIL = "email";
    public static final String KEY_dsn_PASS = "pass";
    //kelas
    public static final String KEY_kls_ID = "idkls";
    public static final String KEY_kls_NAMA = "namakls";
    public static final String KEY_kls_NO = "nokls";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";

    public static final String TAG_maha_ID = "id";
    public static final String TAG_maha_NIM = "nim";
    public static final String TAG_maha_NAMA = "nama";
    public static final String TAG_maha_EMAIl = "email";
    public static final String TAG_maha_PASS = "pass";

    public static final String TAG_dsn_ID = "id";
    public static final String TAG_dsn_NIP = "nip";
    public static final String TAG_dsn_NAMA = "nama";
    public static final String TAG_dsn_EMAIl = "email";
    public static final String TAG_dsn_PASS = "pass";

    public static final String TAG_kelas_NAMA = "namakls";
    public static final String TAG_kelas_NO = "nokls";
    public static final String TAG_kelas_ID = "idkls";

    public static final String DSN_NIP = "dsn_nip";
    public static final String KLS_ID = "kls_id";

}
