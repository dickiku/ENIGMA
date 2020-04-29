package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class SignUpMahasiswa extends AppCompatActivity {
    private Button buttondaftarmahasiswa,kembalikelogin;
    private TextView show;
    private EditText passmaha;
    private EditText namamaha;
    private EditText nimmaha;
    private EditText emailmaha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_mahasiswa);

        buttondaftarmahasiswa = (Button) findViewById(R.id.buttondaftarmahasiswa);
        buttondaftarmahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupMaha();
            }
        });

        kembalikelogin = (Button) findViewById(R.id.kembalikelogin);
        kembalikelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKembaliLogin();
            }
        });

        nimmaha = (EditText) findViewById(R.id.nimmahasignup);
        namamaha = (EditText) findViewById(R.id.namamahasignup);
        emailmaha = (EditText) findViewById(R.id.emailmahasignup);
        passmaha = (EditText) findViewById(R.id.passmahasignup);
        show = (TextView)findViewById(R.id.show);

        show.setVisibility(View.GONE);
        passmaha.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passmaha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(passmaha.getText().length()>0){
                    show.setVisibility(View.VISIBLE);
                }
                else{
                    show.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText() == "SHOW"){
                    show.setText("HIDE");
                    passmaha.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passmaha.setSelection(passmaha.length());
                }
                else{
                    show.setText("SHOW");
                    passmaha.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passmaha.setSelection(passmaha.length());
                }
            }
        });
    }

    public void openSignupMaha(){
        addMaha();
        //Intent intent = new Intent(this,MasukMahasiswa.class);
        //startActivity(intent);
    }
    public void openKembaliLogin(){
        Intent intent = new Intent(this,MahaActivity.class);
        startActivity(intent);
    }
    private void addMaha(){

        final String nama = namamaha.getText().toString().trim();
        final String nim = nimmaha.getText().toString().trim();
        final String email = emailmaha.getText().toString().trim();
        final String pass = passmaha.getText().toString().trim();

        class AddMaha extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SignUpMahasiswa.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(SignUpMahasiswa.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_maha_NIM,nim);
                params.put(konfigurasi.KEY_maha_NAMA,nama);
                params.put(konfigurasi.KEY_maha_EMAIL,email);
                params.put(konfigurasi.KEY_maha_PASS,pass);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                return res;
            }
        }

        AddMaha am = new AddMaha();
        am.execute();
    }
}
