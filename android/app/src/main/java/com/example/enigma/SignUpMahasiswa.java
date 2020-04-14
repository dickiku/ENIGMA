package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpMahasiswa extends AppCompatActivity {
    private Button buttondaftarmahasiswa,kembalikelogin;
    private TextView show;
    private EditText passmaha;
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

        passmaha = (EditText) findViewById(R.id.passmaha);
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
        Intent intent = new Intent(this,SignUpMahasiswa.class);
        startActivity(intent);
    }
    public void openKembaliLogin(){
        Intent intent = new Intent(this,MahaActivity.class);
        startActivity(intent);
    }
}
