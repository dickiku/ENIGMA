package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InfoActivity extends AppCompatActivity {
    private ImageView openbacktoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        openbacktoMain = (ImageView) findViewById(R.id.openbacktoMain);
        openbacktoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openkeMain();
            }
        });
    }
    public void openkeMain(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
