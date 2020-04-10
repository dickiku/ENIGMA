package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpDosen extends AppCompatActivity {
    private Button buttonsignupdos;
    private Button buttonkelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_dosen);

        buttonsignupdos = (Button) findViewById(R.id.buttondaftardosen);
        buttonsignupdos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpDos();
            }
        });

        buttonkelogin = (Button) findViewById(R.id.buttonkelogin);
        buttonkelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKeLogIn();
            }
        });
    }

    public void openSignUpDos(){
        Intent intent = new Intent(this,SignUpDosen.class);
        startActivity(intent);
    }
    public void openKeLogIn(){
        Intent intent = new Intent(this,DosenActivity.class);
        startActivity(intent);
    }
}
