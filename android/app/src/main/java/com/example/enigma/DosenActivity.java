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
import android.widget.ImageView;
import android.widget.TextView;

public class DosenActivity extends AppCompatActivity {
    private Button buttonmasukdosen,buttondaftardosen;
    private ImageView backlogdosen;
    private TextView showpassdsn;
    private EditText passdsnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);

//        Button Masuk Dosen
        buttonmasukdosen = (Button) findViewById(R.id.buttonmasukdosen);
        buttonmasukdosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukDosen();
            }
        });
//        Button back
        backlogdosen = (ImageView) findViewById(R.id.backlogdosen);
        backlogdosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKembaliDosen();
            }
        });
//        Button sign up
        buttondaftardosen = (Button) findViewById(R.id.buttonsignupdosen);
        buttondaftardosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDaftarDosen();
            }
        });

        passdsnlogin = (EditText) findViewById(R.id.passdsnlogin);
        showpassdsn = (TextView)findViewById(R.id.showpassdsn);

        showpassdsn.setVisibility(View.GONE);
        passdsnlogin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passdsnlogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(passdsnlogin.getText().length()>0){
                    showpassdsn.setVisibility(View.VISIBLE);
                }
                else{
                    showpassdsn.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        showpassdsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showpassdsn.getText() == "SHOW"){
                    showpassdsn.setText("HIDE");
                    passdsnlogin.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passdsnlogin.setSelection(passdsnlogin.length());
                }
                else{
                    showpassdsn.setText("SHOW");
                    passdsnlogin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passdsnlogin.setSelection(passdsnlogin.length());
                }
            }
        });
    }

//    Tampil ke Masuk Dosen
    public void openMasukDosen(){
        Intent intent = new Intent(this, MasukDosen.class);
        startActivity(intent);
    }
    public void openKembaliDosen(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void openDaftarDosen(){
        Intent intent = new Intent(this, SignUpDosen.class);
        startActivity(intent);
    }
}
