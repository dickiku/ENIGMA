package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MahaActivity extends AppCompatActivity {
    private Button buttonmasukmaha,tomboldaftar;
    private ImageView backlogmaha;
    private EditText passmahalogin;
    private TextView showlogmaha;
    private String nim, pass;
    private EditText nimmahalogin;
    Boolean CheckEditText;
    public static final String UserNim = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maha);

        buttonmasukmaha = (Button) findViewById(R.id.buttonmasukmaha);
        buttonmasukmaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukMaha();
            }
        });

        backlogmaha = (ImageView) findViewById(R.id.backlogmaha);
        backlogmaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentampilanawal();
            }
        });

        tomboldaftar = (Button) findViewById(R.id.tomboldaftar);
        tomboldaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDaftarAkun();
            }
        });

        nimmahalogin = (EditText) findViewById(R.id.nimmahalogin);
        passmahalogin = (EditText) findViewById(R.id.passmahalogin);
        showlogmaha = (TextView)findViewById(R.id.showlogmaha);

        showlogmaha.setVisibility(View.GONE);
        passmahalogin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passmahalogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(passmahalogin.getText().length()>0){
                    showlogmaha.setVisibility(View.VISIBLE);
                }
                else{
                    showlogmaha.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        showlogmaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showlogmaha.getText() == "SHOW"){
                    showlogmaha.setText("HIDE");
                    passmahalogin.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passmahalogin.setSelection(passmahalogin.length());
                }
                else{
                    showlogmaha.setText("SHOW");
                    passmahalogin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passmahalogin.setSelection(passmahalogin.length());
                }
            }
        });
    }
    public void openMasukMaha(){
        CheckEditTextIsEmptyOrNot();

        if(CheckEditText){

            LoginMhs(nim, pass);

        }
        else {

            Toast.makeText(MahaActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

        }
//        Intent intent = new Intent(this,MasukMahasiswa.class);
//        startActivity(intent);
    }
    public void opentampilanawal(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    public void openDaftarAkun(){
        Intent intent = new Intent(this,SignUpMahasiswa.class);
        startActivity(intent);
    }

    public void CheckEditTextIsEmptyOrNot(){

        nim = nimmahalogin.getText().toString();
        pass = passmahalogin.getText().toString();

        if(TextUtils.isEmpty(nim) || TextUtils.isEmpty(pass))
        {
            CheckEditText = false;
        }
        else {

            CheckEditText = true ;
        }
    }
    public void LoginMhs(final String nim, final String password){

        class LoginMhsClass extends AsyncTask<String,Void,String> {
            ProgressDialog progressDialog;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(MahaActivity.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                    finish();

                    Intent intent = new Intent(MahaActivity.this, MasukMahasiswa.class);

                    intent.putExtra(UserNim,nim);

                    startActivity(intent);

                }
                else{

                    Toast.makeText(MahaActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            protected String doInBackground(String... s) {

                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_maha_NIM,nim);
                params.put(konfigurasi.KEY_maha_PASS,password);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_LOGIN_MHS, params);
                return res;
            }
        }

        LoginMhsClass mahaLoginClass = new LoginMhsClass();
        mahaLoginClass.execute(nim,password);
    }

}