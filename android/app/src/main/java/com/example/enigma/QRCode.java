package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class QRCode extends AppCompatActivity {
    private ImageView backqr;
    private String nimQrHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        Intent intent = getIntent();
        nimQrHolder = intent.getStringExtra(MasukMahasiswa.mahaNim);

        backqr = (ImageView) findViewById(R.id.imageView);
        Glide.with(QRCode.this)
                // LOAD URL DARI INTERNET
                .load(konfigurasi.URL_Qr_nim + nimQrHolder +".png")
//                .load(konfigurasi.URL_Qr_nim +"A11.2017.10115.png");
                // LOAD GAMBAR AWAL SEBELUM GAMBAR UTAMA MUNCUL, BISA DARI LOKAL DAN INTERNET
                //.placeholder()
                .into(backqr);
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
