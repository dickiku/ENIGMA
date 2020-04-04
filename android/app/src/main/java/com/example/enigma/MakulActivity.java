package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MakulActivity extends AppCompatActivity {
    private Button buttonmakul1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makul);

        buttonmakul1 = (Button) findViewById(R.id.buttonmakul1);
        buttonmakul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMakulActivity();
            }
        });
    }

    public void openMakulActivity(){
        Intent intent = new Intent(this, ListKehadiran.class);
        startActivity(intent);
    }
}
