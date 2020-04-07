package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MasukDosen extends AppCompatActivity {
    private Button buttonlist;
    private Button buttonabsen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk_dosen);

        buttonlist = (Button) findViewById(R.id.buttonlist);
        buttonlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlistkehadiran();
            }
        });

        buttonabsen = (Button) findViewById(R.id.buttonabsen);
        buttonabsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbsenScanner();
            }
        });

    }
    public void openlistkehadiran(){
        Intent intent = new Intent(this,MakulActivity.class);
        startActivity(intent);
    }
    public void openAbsenScanner(){
        Intent intent = new Intent(this,AbsenScanner.class);
        startActivity(intent);
    }
}
