package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MasukDosen extends AppCompatActivity {
    private Button buttonlist;
    private Button buttonabsen;
    private Button outdosen;
    TextView EmailShow;
    String EmailHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk_dosen);

        EmailShow = (TextView)findViewById(R.id.namadsnmasuk);

        Intent intent = getIntent();
        EmailHolder = intent.getStringExtra(DosenActivity.UserEmail);
        EmailShow.setText(EmailHolder);

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

        outdosen = (Button) findViewById(R.id.outdosen);
        outdosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKembaliKeHome();
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
    public void openKembaliKeHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
