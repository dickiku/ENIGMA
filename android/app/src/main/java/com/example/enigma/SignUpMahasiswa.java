package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpMahasiswa extends AppCompatActivity {
    private Button buttondaftarmahasiswa,kembalikelogin;
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
