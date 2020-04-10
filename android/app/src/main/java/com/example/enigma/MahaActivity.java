package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MahaActivity extends AppCompatActivity {
    private Button buttonmasukmaha,tomboldaftar;
    private ImageView backlogmaha;

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
    }
    public void openMasukMaha(){
        Intent intent = new Intent(this,MasukMahasiswa.class);
        startActivity(intent);
    }
    public void opentampilanawal(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    public void openDaftarAkun(){
        Intent intent = new Intent(this,SignUpMahasiswa.class);
        startActivity(intent);
    }
}