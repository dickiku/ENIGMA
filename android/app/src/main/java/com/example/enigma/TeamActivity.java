package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TeamActivity extends AppCompatActivity {

    private ImageView OpenBacktoMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        OpenBacktoMainMenu = (ImageView) findViewById(R.id.OpenBacktoMainMenu);
        OpenBacktoMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenkeMenuAwal();
            }
        });
    }

    public void OpenkeMenuAwal(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
