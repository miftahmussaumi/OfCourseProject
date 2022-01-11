package com.example.ofcourse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ofcourse.Model.ResponseTransaksi;
import com.example.ofcourse.api.ApiClient;
import com.example.ofcourse.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import Adapter.Transaksi1Adapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sudah extends AppCompatActivity {
    RecyclerView recyclerView;
    Transaksi1Adapter transaksi1Adapter;
    List<ResponseTransaksi> list;
    SessionManager sessionManager;
    Button buttonselesai, buttonsedangdiproses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudah);
        buttonselesai = findViewById(R.id.buttonselesai);
        buttonsedangdiproses = findViewById(R.id.buttonsedangdiproses);

        buttonselesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(sudah.this, sudah.class);
                startActivity(intent);
            }
        });

        buttonsedangdiproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(sudah.this, belum.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.rv_setuju);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sessionManager = new SessionManager(sudah.this);
        String id_users = sessionManager.getUserDetail().get(SessionManager.ID);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<ResponseTransaksi>> call = apiInterface.getTransaksiSudah(id_users);
        call.enqueue(new Callback<List<ResponseTransaksi>>() {
            @Override
            public void onResponse(Call<List<ResponseTransaksi>> call, Response<List<ResponseTransaksi>> response) {
                list = response.body();
                transaksi1Adapter = new Transaksi1Adapter(list,sudah.this);
                recyclerView.setAdapter(transaksi1Adapter);
            }

            @Override
            public void onFailure(Call<List<ResponseTransaksi>> call, Throwable t) {
                Log.d("TAG", "onFailure"+t.getLocalizedMessage());
            }
        });
    }
}