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
    private ListView listkelas;

    private String JSON_STRING;
    private ImageView backtomasukdosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kehadiran);

        backtomasukdosen = (ImageView) findViewById(R.id.backtomasukdosen);
        backtomasukdosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukDosen();
            }
        });

        listkelas = (ListView) findViewById(R.id.listkelas);
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
                ListKehadiran.this, list, R.layout.list_kelas,
                new String[]{konfigurasi.TAG_maha_NIM,konfigurasi.TAG_maha_NAMA},
                new int[]{R.id.nimmahalist, R.id.namamahalist});

        listkelas.setAdapter(adapter);
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
                String s = rh.sendGetRequest(konfigurasi.URL_List_Kehadiran);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

 /*   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, TampilPegawai.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empId = map.get(konfigurasi.TAG_ID).toString();
        intent.putExtra(konfigurasi.EMP_ID,empId);
        startActivity(intent);
    }*/
    public void openMasukDosen(){
        Intent intent = new Intent(this, MasukDosen.class);
        startActivity(intent);
    }
}

