package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DosenActivity extends AppCompatActivity {
    private Button buttonmasukdosen;
    private ImageView backlogdosen;


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
//        Button back
        backlogdosen = (ImageView) findViewById(R.id.backlogdosen);
        backlogdosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKembaliDosen();
            }
        });
//        Button sign up
    }

//    Tampil ke Masuk Dosen
    public void openMasukDosen(){
        Intent intent = new Intent(this, MasukDosen.class);
        startActivity(intent);
    }
    public void openKembaliDosen(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
