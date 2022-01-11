package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.ofcourse.Model.ResponseGuru;
import com.example.ofcourse.Model.ResponseReview;
import com.example.ofcourse.api.ApiClient;
import com.example.ofcourse.api.ApiInterface;

import Adapter.ReviewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class DetailGuru extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";
    Button butonreservasi;
    TextView guru,mapel,pendidikan,ket_guru,biaya;
    ResponseGuru responseGuru;
    List<ResponseReview> list;
    RecyclerView recyclerView;
    ReviewAdapter reviewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_guru);

        guru        = findViewById(R.id.d_nama_guru);
        mapel       = findViewById(R.id.d_mapel_guru);
        pendidikan  = findViewById(R.id.d_pendidikan);
        ket_guru    = findViewById(R.id.d_ket_guru);
        biaya       = findViewById(R.id.d_biaya);

        responseGuru = (ResponseGuru) getIntent().getSerializableExtra("review");
        String d_guru = responseGuru.getNamaGuru();
        String d_mapel = responseGuru.getNamaMapel();
        String d_pendidikan = responseGuru.getPendidikan();
        String d_ket_guru = responseGuru.getKetGuru();
        Integer d_biaya = responseGuru.getUpah();
        Integer d_idguru = responseGuru.getIdGuru();
        Integer d_idmapel = responseGuru.getId();

        guru.setText(d_guru);
        mapel.setText(d_mapel);
        pendidikan.setText(d_pendidikan);
        ket_guru.setText(d_ket_guru);
        biaya.setText("Rp " + String.valueOf(d_biaya) + " /jam");

        recyclerView = findViewById(R.id.rv_review);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<ResponseReview>>call = apiInterface.getReview(responseGuru.getIdGuru());
        call.enqueue(new Callback<List<ResponseReview>>() {
            @Override
            public void onResponse(Call<List<ResponseReview>> call, Response<List<ResponseReview>> response) {
                list = response.body();
                reviewAdapter = new ReviewAdapter(list,DetailGuru.this);
                recyclerView.setAdapter(reviewAdapter);
            }

            @Override
            public void onFailure(Call<List<ResponseReview>> call, Throwable t) {
                Log.d("TAG", "onFailure : "+t.getLocalizedMessage());
            }
        });

        butonreservasi = findViewById(R.id.buttonReservasi);
        butonreservasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DetailGuru.this, Formreservasi.class);
                intent.putExtra("d_idguru", d_idguru);
                intent.putExtra("d_idmapel", d_idmapel);
                startActivity(intent);
            }
        });


    }

}