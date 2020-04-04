package com.example.enigma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListKehadiran extends AppCompatActivity {

    private RecyclerView rvList;
    private RecycleAdapter adapter;
    private List<kelasss> listKelas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kehadiran);

        rvList = findViewById(R.id.listkelas);
        kelasss k1 = new kelasss("Dicki Kurniawan","A11.2017.10104");
        kelasss k2 = new kelasss("Dicki Kurniawan","A11.2017.10104");
        kelasss k3 = new kelasss("Dicki Kurniawan","A11.2017.10104");
        kelasss k4 = new kelasss("Dicki Kurniawan","A11.2017.10104");
        kelasss k5 = new kelasss("Dicki Kurniawan","A11.2017.10104");
        kelasss k6 = new kelasss("Dicki Kurniawan","A11.2017.10104");
        kelasss k7 = new kelasss("Dicki Kurniawan","A11.2017.10104");
        kelasss k8 = new kelasss("Dicki Kurniawan","A11.2017.10104");

        listKelas.add(0,k1);
        listKelas.add(1,k2);
        listKelas.add(2,k3);
        listKelas.add(3,k4);
        listKelas.add(4,k5);
        listKelas.add(5,k6);
        listKelas.add(6,k7);
        listKelas.add(7,k8);
        adapter = new RecycleAdapter(this);
        adapter.setListKelas(listKelas);

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

    }


}

