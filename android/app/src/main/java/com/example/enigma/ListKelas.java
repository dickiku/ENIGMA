package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

import static com.example.enigma.DosenActivity.UserNIP;

public class ListKelas extends AppCompatActivity implements ListView.OnItemClickListener{
    private ListView listkelas;

    private String JSON_STRING;
    private ImageView kemenudosen;
    String nipHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kelas);

        kemenudosen = (ImageView) findViewById(R.id.kemenudosen);
        kemenudosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kemenudosenlagi();
            }
        });

        Intent intent = getIntent();
        nipHolder = intent.getStringExtra(UserNIP);

        listkelas = (ListView) findViewById(R.id.listkelas);
        listkelas.setOnItemClickListener(this);
        getJSON();
    }


    private void showKelas(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String nama = jo.getString(konfigurasi.TAG_kelas_NAMA);
                String nomor = jo.getString(konfigurasi.TAG_kelas_NO);
                String id = jo.getString(konfigurasi.TAG_kelas_ID);

                HashMap<String,String> kelas = new HashMap<>();
                kelas.put(konfigurasi.TAG_kelas_NAMA,nama);
                kelas.put(konfigurasi.TAG_kelas_NO,nomor);
                kelas.put(konfigurasi.TAG_kelas_ID,id);
                list.add(kelas);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                ListKelas.this, list, R.layout.list_kelas,
                new String[]{konfigurasi.TAG_kelas_NAMA,konfigurasi.TAG_kelas_NO},
                new int[]{R.id.namakelaslist, R.id.nokelaslist});

        listkelas.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ListKelas.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showKelas();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_List_Kelas);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           Intent intent = new Intent(this, AbsenScanner.class);
           HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
           String klsId = map.get(konfigurasi.TAG_kelas_ID);
           intent.putExtra(konfigurasi.KLS_ID,klsId);
           intent.putExtra(konfigurasi.DSN_NIP,nipHolder);
           startActivity(intent);
       }
    public void kemenudosenlagi(){
        Intent intent = new Intent(this, MasukDosen.class);
        startActivity(intent);
    }
}

