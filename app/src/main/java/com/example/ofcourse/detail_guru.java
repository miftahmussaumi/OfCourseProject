package com.example.ofcourse;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import Adapter.ReviewAdapter;
import Model.Mapel;
import Model.Review;

import java.util.ArrayList;

public class detail_guru extends AppCompatActivity {
    RecyclerView rvReview;
    ReviewAdapter reviewAdapter;
    public static final String ITEM_EXTRA = "item_extra";
    Button butonreservasi;
    private TextView guru, mapl, biaya, biayaa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_guru);


        reviewAdapter = new ReviewAdapter();
        reviewAdapter.setListReview(generateData());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvReview= findViewById(R.id.rvReview);
        rvReview.setAdapter(reviewAdapter);
        rvReview.setLayoutManager(layoutManager);

        ImageView foto_guru = findViewById(R.id.d_foto_guru);
        TextView nama_guru  = findViewById(R.id.d_nama_guru);
        TextView mapel_guru = findViewById(R.id.d_mapel_guru);
        TextView score_guru = findViewById(R.id.d_score_guru);

        Mapel mapel = getIntent().getParcelableExtra(ITEM_EXTRA);
        if(mapel != null){
            nama_guru.setText(mapel.getLm_guru());
            mapel_guru.setText(mapel.getLm_mapel());
            score_guru.setText(mapel.getLm_score());
        }
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail Guru");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        guru = (TextView) findViewById(R.id.d_nama_guru);
        mapl = (TextView) findViewById(R.id.d_mapel_guru);
        biaya = (TextView) findViewById(R.id.biaya);

        butonreservasi = findViewById(R.id.buttonReservasi);
        butonreservasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detail_guru.this, Formreservasi.class);
                intent.putExtra("namaguru", guru.getText().toString());
                intent.putExtra("mapel", mapl.getText().toString());
                intent.putExtra("biaya", biaya.getText().toString());
                startActivity(intent);
            }
        });

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

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }



    private ArrayList<Review> generateData() {
        ArrayList<Review> listReview = new ArrayList<>();
        listReview.add(new Review("Jennie Jane", "Classes with Mrs. Alia have been so worthwhile. Her lessons were engaging, useful, and fun!"));
        listReview.add(new Review("Renee Jane", "Mrs. Alia have been so worthwhile. Her lessons were engaging, useful, and fun!"));
        listReview.add(new Review("Faye Jane", "Have been so worthwhile. Her lessons were engaging, useful, and fun!"));
        listReview.add(new Review("Rose Jane", "Classes with Mrs. Alia have been so worthwhile. Her lessons were engaging, useful, and fun!"));
        listReview.add(new Review("Jesse Jane", "Alia have been so worthwhile. Her lessons were engaging, useful, and fun!"));

        return listReview;
    }

}