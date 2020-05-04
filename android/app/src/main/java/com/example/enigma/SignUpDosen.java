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

public class SignUpDosen extends AppCompatActivity {
    private Button buttonsignupdos;
    private Button buttonkelogin;
    private TextView showpassdosen;
    private EditText passdosen;
    private EditText nipdosen;
    private EditText namadosen;
    private EditText emaildosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_dosen);

        buttonsignupdos = (Button) findViewById(R.id.buttondaftardosen);
        buttonsignupdos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpDos();
            }
        });

        buttonkelogin = (Button) findViewById(R.id.buttonkelogin);
        buttonkelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKeLogIn();
            }
        });

        nipdosen = (EditText) findViewById(R.id.nipdsnsignup);
        namadosen = (EditText) findViewById(R.id.namadsnsignup);
        emaildosen = (EditText) findViewById(R.id.emaildsnsignup);
        passdosen = (EditText) findViewById(R.id.passdosensignup);
        showpassdosen = (TextView)findViewById(R.id.showpassdosen);


        showpassdosen.setVisibility(View.GONE);
        passdosen.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passdosen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(passdosen.getText().length()>0){
                    showpassdosen.setVisibility(View.VISIBLE);
                }
                else{
                    showpassdosen.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        showpassdosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showpassdosen.getText() == "SHOW"){
                    showpassdosen.setText("HIDE");
                    passdosen.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passdosen.setSelection(passdosen.length());
                }
                else{
                    showpassdosen.setText("SHOW");
                    passdosen.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passdosen.setSelection(passdosen.length());
                }
            }
        });

    }

    public void openSignUpDos(){
        addDosen();
        //Intent intent = new Intent(this,SignUpDosen.class);
        //startActivity(intent);
    }
    public void openKeLogIn(){
        Intent intent = new Intent(this,DosenActivity.class);
        startActivity(intent);
    }
    private void addDosen(){

        final String nama = namadosen.getText().toString().trim();
        final String nip = nipdosen.getText().toString().trim();
        final String email = emaildosen.getText().toString().trim();
        final String pass = passdosen.getText().toString().trim();

        class AddDosen extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SignUpDosen.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(SignUpDosen.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_dsn_NIP,nip);
                params.put(konfigurasi.KEY_dsn_NAMA,nama);
                params.put(konfigurasi.KEY_dsn_EMAIL,email);
                params.put(konfigurasi.KEY_dsn_PASS,pass);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD_DSN, params);
                return res;
            }
        }

        AddDosen ad = new AddDosen();
        ad.execute();
    }
}
