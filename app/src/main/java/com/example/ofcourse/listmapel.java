package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import Adapter.DashboardAdapter;
import Adapter.MapelAdapter;
import Model.Dashboard;
import Model.Mapel;

public class listmapel extends AppCompatActivity {
    RecyclerView recyclerView;
    MapelAdapter mapelAdapter;
    ArrayList<Mapel> datamapel;
    LinearLayoutManager layoutManager;
    TextView textLabelMapel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmapel);

        recyclerView = findViewById(R.id.rv_mapel);
        addData();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mapelAdapter = new MapelAdapter(datamapel);
        recyclerView.setAdapter(mapelAdapter);

        Intent detailMapelIntent = getIntent();
        String namaMapel = detailMapelIntent.getStringExtra("MAPEL");
        textLabelMapel = findViewById(R.id.judul_mapel);
        textLabelMapel.setText(namaMapel);
//        mapelAdapter.setClickObject(this);

        mapelAdapter.setClickObject(new MapelAdapter.OnMapelViewHolderClick() {
            @Override
            public void onClick(Mapel mapel) {
                Intent moveIntent = new Intent(listmapel.this,detail_guru.class);
                moveIntent.putExtra(detail_guru.ITEM_EXTRA,mapel);
                startActivity(moveIntent);
            }
        });
    }

    public void addData(){
        datamapel = new ArrayList<>();
        datamapel.add(new Mapel("Alia Zalea", "Matematika","Padang, Sumatera Barat","5.0","profil1"));
        datamapel.add(new Mapel("Erisca Febrianne", "Matematika","Jakarta","4.8","profil"));
        datamapel.add(new Mapel("Fajrul Sasad","Matematika","Jakarta","4.8","profil2"));
        datamapel.add(new Mapel("Thomas Schdmit","Matematika","Jakarta","4.8","profil3"));
        datamapel.add(new Mapel("Yulian Sriminov","Matematika","Jakarta","4.8","profil"));
        datamapel.add(new Mapel("Irvandi Frozan","Matematika","Jakarta","4.8","profil2"));datamapel.add(new Mapel("Yulian Sriminov","Matematika","Jakarta","4.8","profil"));
        datamapel.add(new Mapel("Irvandi Frozan","Matematika","Jakarta","4.8","profil2"));datamapel.add(new Mapel("Yulian Sriminov","Matematika","Jakarta","4.8","profil"));
        datamapel.add(new Mapel("Irvandi Frozan","Matematika","Jakarta","4.8","profil2"));
    }

//    @Override
//    public void onClick(Mapel mapel) {
//        Intent detailIntent =  new Intent(this,listmapel.class);
//        detailIntent.putExtra("MAPEL",dashboard.getTitle());
//        startActivity(detailIntent);
//    }
}