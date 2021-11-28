package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import Adapter.DashboardAdapter;
import Model.Dashboard;

public class dashboard extends AppCompatActivity implements DashboardAdapter.OnDashViewHolderClick{
    RecyclerView recyclerView;
    ArrayList<Model.Dashboard> datamenu;
    GridLayoutManager gridLayoutManager;
    DashboardAdapter dashboardAdapter;
    ImageView profil,pencarian;
    Button pemesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.rv_menu);
        addData();
        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        dashboardAdapter = new DashboardAdapter(datamenu);
        recyclerView.setAdapter(dashboardAdapter);
        dashboardAdapter.setClickObject(this);

        profil = findViewById(R.id.foto_profil);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        pencarian = findViewById(R.id.pencarian);
        pencarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, pencarian.class);
                startActivity(intent);
            }
        });

//        pemesanan = findViewById(R.id.pemesanan);
//        profil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(dashboard.this, pemesanan_activity.class);
//                startActivity(intent);
//            }
//        });
    }

    public void addData(){
        datamenu = new ArrayList<>();
        datamenu.add(new Model.Dashboard("Matematika","pictmat"));
        datamenu.add(new Model.Dashboard("Kimia","pictkim"));
        datamenu.add(new Model.Dashboard("Fisika","pictfis"));
        datamenu.add(new Model.Dashboard("English","picteng"));
        datamenu.add(new Model.Dashboard("Biologi","pictbio"));
        datamenu.add(new Model.Dashboard("TPA","picttpa"));
        datamenu.add(new Model.Dashboard("Gitar","pictgitar"));
        datamenu.add(new Model.Dashboard("Piano","pictpiano"));
        datamenu.add(new Model.Dashboard("Biola","pictbiola"));
    }

    @Override
    public void onClick(Dashboard dashboard) {
        Intent detailIntent =  new Intent(this,listmapel.class);
        detailIntent.putExtra("MAPEL",dashboard.getTitle());
        startActivity(detailIntent);
    }
}