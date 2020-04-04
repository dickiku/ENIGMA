package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DosenActivity extends AppCompatActivity {
    private Button buttonmasukdosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);

//        Button Masuk Dosen
        buttonmasukdosen = (Button) findViewById(R.id.buttonmasukdosen);
        buttonmasukdosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukDosen();
            }
        });
    }

//    Tampil ke Masuk Dosen
    public void openMasukDosen(){
        Intent intent = new Intent(this, MasukDosen.class);
        startActivity(intent);
    }
}
