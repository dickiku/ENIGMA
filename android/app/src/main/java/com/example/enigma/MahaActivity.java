package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MahaActivity extends AppCompatActivity {
    private Button buttonmasukmaha;

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
    }
    public void openMasukMaha(){
        Intent intent = new Intent(this,MasukMahasiswa.class);
        startActivity(intent);
    }
}
