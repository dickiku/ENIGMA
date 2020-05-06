package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.enigma.MahaActivity;
import com.example.enigma.R;

public class HomeActivity extends AppCompatActivity {
    private CardView buttonmaha;
    private CardView buttondosen;
    private CardView buttoninfo;
    private CardView buttonteam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Button Mahasiswa
        buttonmaha = (CardView) findViewById(R.id.buttonmaha);
        buttonmaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMahaActivity();
            }
        });

//        Button Dosen
        buttondosen = (CardView) findViewById(R.id.buttondosen);
        buttondosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDosenActivity();
            }
        });

        buttoninfo = (CardView) findViewById(R.id.buttoninfo);
        buttoninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfoActivity();
            }
        });

        buttonteam = (CardView) findViewById(R.id.buttonteam);
        buttonteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTeamActivity();
            }
        });

    }
//    Tampilan ke LogIn Mahasiswa
    public void openMahaActivity(){
        Intent intent = new Intent(this, MahaActivity.class);
        startActivity(intent);
    }
//    Tampilan ke LogIn Dosen
    public void openDosenActivity(){
        Intent intent = new Intent(this, DosenActivity.class);
        //Intent intent = new Intent(this, DosenActivity.class);
        startActivity(intent);
    }
    public void openInfoActivity(){
        Intent intent = new Intent(this,InfoActivity.class);
        startActivity(intent);
    }
    public void openTeamActivity(){
        Intent intent = new Intent(this,TeamActivity.class);
        startActivity(intent);
    }
}
