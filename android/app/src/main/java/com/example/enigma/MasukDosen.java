package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.enigma.DosenActivity.UserNIP;

public class MasukDosen extends AppCompatActivity {
    private Button buttonlist;
    private Button buttonabsen;
    private Button outdosen;
    TextView namaShow;
    TextView nipShow;
    String namaHolder;
    String nipHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk_dosen);

        namaShow = (TextView)findViewById(R.id.namadsnmasuk);
        nipShow = (TextView)findViewById(R.id.nipdsnmasuk);

        Intent intent = getIntent();
        //namaHolder = intent.getStringExtra(DosenActivity.UserNama);
        nipHolder = intent.getStringExtra(UserNIP);
        //namaShow.setText(namaHolder);
        nipShow.setText(nipHolder);

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
        Intent intent = new Intent(this,tampil_kelas.class);
        startActivity(intent);
    }
    public void openAbsenScanner(){
        Intent intent = new Intent(this,ListKelas.class);
        intent.putExtra(UserNIP,nipHolder);
        startActivity(intent);
    }
    public void openKembaliKeHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
