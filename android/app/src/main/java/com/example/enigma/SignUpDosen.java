package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpDosen extends AppCompatActivity {
    private Button buttonsignupdos;
    private Button buttonkelogin;
    private TextView showpassdosen;
    private EditText passdosen;

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

        passdosen = (EditText) findViewById(R.id.passdosen);
        showpassdosen = (TextView)findViewById(R.id.showpassdosen);


        showpassdosen.setVisibility(View.GONE);
        passdosen.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passdosen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(passdosen.getText().length()>0){
                    showpassdosen.setVisibility(View.VISIBLE);
                }
                else{
                    showpassdosen.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        showpassdosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showpassdosen.getText() == "SHOW"){
                    passdosen.setText("HIDE");
                    passdosen.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passdosen.setSelection(passdosen.length());
                }
                else{
                    showpassdosen.setText("SHOW");
                    passdosen.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passdosen.setSelection(passdosen.length());
                }
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
