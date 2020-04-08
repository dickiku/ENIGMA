package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QRCode extends AppCompatActivity {
    private ImageView backqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        backqr = (ImageView) findViewById(R.id.backqr);
        backqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbackMaha();
            }
        });
    }

    public void openbackMaha(){
        Intent intent = new Intent(this, MasukMahasiswa.class);
        startActivity(intent);
    }
}
