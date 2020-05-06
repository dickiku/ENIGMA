package com.example.enigma;

public class konfigurasi {
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD_MHS="http://192.168.18.8/Enigma/database/addMaha.php";
    public static final String URL_ADD_DSN="http://192.168.18.8/Enigma/database/addDosen.php";
//    public static final String URL_GET_ALL = "http://192.168.100.12/Android/pegawai/tampilSemuaPgw.php";
//    public static final String URL_GET_EMP = "http://192.168.100.12/Android/pegawai/tampilPgw.php?id=";
//    public static final String URL_UPDATE_EMP = "http://192.168.100.12/Android/pegawai/updatePgw.php";
//    public static final String URL_DELETE_EMP = "http://192.168.100.12/Android/pegawai/hapusPgw.php?id=";

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

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_maha_NIM = "nim";
    public static final String TAG_maha_NAMA = "nama";
    public static final String TAG_maha_EMAIl = "email";
    public static final String TAG_maha_PASS = "pass";
}
