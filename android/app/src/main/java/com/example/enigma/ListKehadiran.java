package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListKehadiran extends AppCompatActivity{
// implements ListView.OnItemClickListener
    private ListView listhadir;

    private String JSON_STRING;
    private ImageView backtomasukdosen;
    private String nipHolder;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kehadiran);

        Intent intent = getIntent();
        nipHolder = intent.getStringExtra(konfigurasi.DSN_NIP);
        id = intent.getStringExtra(konfigurasi.KLS_ID);


        backtomasukdosen = (ImageView) findViewById(R.id.backtomasukdosen);
        backtomasukdosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukDosen();
            }
        });

        listhadir = (ListView) findViewById(R.id.listhadir);
//        listKelas.setOnItemClickListener(this);
        getJSON();
    }


    private void showHadir(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String nim = jo.getString(konfigurasi.TAG_maha_NIM);
                String nama = jo.getString(konfigurasi.TAG_maha_NAMA);

                HashMap<String,String> hadir = new HashMap<>();
                hadir.put(konfigurasi.TAG_maha_NIM,nim);
                hadir.put(konfigurasi.TAG_maha_NAMA,nama);
                list.add(hadir);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                ListKehadiran.this, list, R.layout.list_hadir,
                new String[]{konfigurasi.TAG_maha_NIM,konfigurasi.TAG_maha_NAMA},
                new int[]{R.id.nimmahalist, R.id.namamahalist});

        listhadir.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ListKehadiran.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showHadir();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParamId(konfigurasi.URL_List_Kehadiran,id);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    public void openMasukDosen(){
        Intent intent = new Intent(this, tampil_kelas.class);
        intent.putExtra(konfigurasi.DSN_NIP,nipHolder);
        startActivity(intent);
    }
}

