package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ofcourse.Model.ResponseGuru;
import com.example.ofcourse.Model.ResponseMenu;
import com.example.ofcourse.api.ApiClient;
import com.example.ofcourse.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import Adapter.GuruAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListGuru extends AppCompatActivity{

    ResponseMenu menu;
    List<ResponseGuru> list;
    RecyclerView recyclerView;
    GuruAdapter adapter;
    TextView mapel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmapel);

        mapel = findViewById(R.id.judul_mapel);

        menu = (ResponseMenu) getIntent().getSerializableExtra("post");

        String nama_mapel = menu.getNamaMapel();
        mapel.setText(nama_mapel);

        recyclerView = findViewById(R.id.rv_mapel);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<ResponseGuru>> call = apiInterface.getDataGuru(menu.getId());
        call.enqueue(new Callback<List<ResponseGuru>>() {
            @Override
            public void onResponse(Call<List<ResponseGuru>> call, Response<List<ResponseGuru>> response) {
                list = response.body();
                adapter = new GuruAdapter(list, ListGuru.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ResponseGuru>> call, Throwable t) {
                Log.d("TAG", "onFailure"+t.getLocalizedMessage());
            }
        });

    }

}