package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import Adapter.PencarianAdapter;
import Model.Pencarian;

public class pencarian extends AppCompatActivity {
    RecyclerView recyclerView;
    PencarianAdapter pencarianAdapter;
    ArrayList<Pencarian> datapencarian;
    LinearLayoutManager layoutManager;
    Button map;
//    TextView textLabelPencarian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);

        map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pencarian.this, get_location.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rv_pencarian);
        addData();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        pencarianAdapter = new PencarianAdapter(datapencarian);
        recyclerView.setAdapter(pencarianAdapter);

//        Intent detailPencarianIntent = getIntent();
//        String namaPencarian = detailPencarianIntent.getStringExtra("Pencarian");
//        textLabelPencarian = findViewById(R.id.judul_Pencarian);
//        textLabelPencarian.setText(namaPencarian);
//        PencarianAdapter.setClickObject(this);

        pencarianAdapter.setClickObject(new PencarianAdapter.OnPencarianViewHolderClick() {
            @Override
            public void onClick(Pencarian pencarian) {
                Intent moveIntent = new Intent(pencarian.this, DetailGuru.class);
                moveIntent.putExtra(DetailGuru.ITEM_EXTRA,pencarian);
                startActivity(moveIntent);
            }
        });
    }

    public void addData(){
        datapencarian = new ArrayList<>();
        datapencarian.add(new Pencarian("Alia Zalea", "Bahasa Inggris","Padang, Sumatera Barat","5.0","profil1"));
        datapencarian.add(new Pencarian("Erisca Febrianne", "Bahasa Inggris","Padang","4.8","profil"));
        datapencarian.add(new Pencarian("Fajrul Sasad","Bahasa Inggris","Padang","4.8","profil2"));
        datapencarian.add(new Pencarian("Thomas Schdmit","Bahasa Inggris","Padang","4.8","profil3"));
        datapencarian.add(new Pencarian("Yulian Sriminov","Bahasa Inggris","Padang","4.8","profil"));
        datapencarian.add(new Pencarian("Irvandi Frozan","Bahasa Inggris","Padang","4.8","profil2"));datapencarian.add(new Pencarian("Yulian Sriminov","Bahasa Inggris","Jakarta","4.8","profil"));
        datapencarian.add(new Pencarian("Irvandi Frozan","Bahasa Inggris","Padang","4.8","profil2"));datapencarian.add(new Pencarian("Yulian Sriminov","Bahasa Inggris","Jakarta","4.8","profil"));
        datapencarian.add(new Pencarian("Irvandi Frozan","Bahasa Inggris","Padang","4.8","profil2"));
    }

//    @Override
//    public void onClick(Pencarian Pencarian) {
//        Intent detailIntent =  new Intent(this,listPencarian.class);
//        detailIntent.putExtra("Pencarian",dashboard.getTitle());
//        startActivity(detailIntent);
//    }
}