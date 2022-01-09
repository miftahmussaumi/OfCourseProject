package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.ofcourse.Model.ResponseDetailGuru;
import com.example.ofcourse.Model.ResponseGuru;

import Adapter.GuruAdapter;
import Adapter.ReviewAdapter;
import Model.Mapel;
import Model.Review;

import java.util.ArrayList;

public class DetailGuru extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";
    Button butonreservasi;
    TextView guru,mapel,pendidikan,ket_guru,biaya;
    ResponseGuru responseGuru;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_guru);

        guru        = findViewById(R.id.d_nama_guru);
        mapel       = findViewById(R.id.d_mapel_guru);
        pendidikan  = findViewById(R.id.d_pendidikan);
        ket_guru    = findViewById(R.id.d_ket_guru);
        biaya       = findViewById(R.id.d_biaya);

        responseGuru = getIntent().getParcelableExtra(ITEM_EXTRA);
        String d_guru = responseGuru.getNamaGuru();
        String d_mapel = responseGuru.getNamaMapel();
        String d_pendidikan = responseGuru.getPendidikan();
        String d_ket_guru = responseGuru.getKetGuru();
        Integer d_biaya = responseGuru.getUpah();

        guru.setText(d_guru);
        mapel.setText(d_mapel);
        pendidikan.setText(d_pendidikan);
        ket_guru.setText(d_ket_guru);
        biaya.setText("Rp " + String.valueOf(d_biaya) + "/jam");



//        butonreservasi = findViewById(R.id.buttonReservasi);
//        butonreservasi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(detail_guru.this, Formreservasi.class);
//                startActivity(intent);
//            }
//        });


    }

}