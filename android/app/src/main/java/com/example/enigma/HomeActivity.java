package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.enigma.MahaActivity;
import com.example.enigma.R;

public class HomeActivity extends AppCompatActivity {
    private Button buttonmaha;
    private Button buttondosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Button Mahasiswa
        buttonmaha = (Button) findViewById(R.id.buttonmaha);
        buttonmaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMahaActivity();
            }
        });

//        Button Dosen
        buttondosen = (Button) findViewById(R.id.buttondosen);
        buttondosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDosenActivity();
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
        Intent intent = new Intent(this,DosenActivity.class);
        startActivity(intent);
    }
}
