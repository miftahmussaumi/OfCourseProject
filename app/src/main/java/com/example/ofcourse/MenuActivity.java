package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ofcourse.api.ApiClient;
import com.example.ofcourse.api.ApiInterface;

import java.util.List;
import java.util.concurrent.RecursiveTask;

import Adapter.DashboardAdapter;
import Adapter.MenuAdapter;
import Model.Dashboard;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity implements MenuAdapter.OnDashViewHolderClick{

    RecyclerView recyclerView;
    RecyclerView recview;
    MenuAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    ImageView profil,pencarian;
    Button pemesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = findViewById(R.id.recview);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        profil = findViewById(R.id.foto_profil);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        pencarian = findViewById(R.id.pencarian);
        pencarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, pencarian.class);
                startActivity(intent);
            }
        });

        pemesanan = findViewById(R.id.pemesanan);
        pemesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, pesanan_belum_disetujui.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ofcourse2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<responsemodel>> call = apiInterface.getPost();
        call.enqueue(new Callback<List<responsemodel>>() {
            @Override
            public void onResponse(Call<List<responsemodel>> call, Response<List<responsemodel>> response) {

                if (response.isSuccessful()){
                    List<responsemodel> posts = response.body();
                    adapter = new MenuAdapter(MenuActivity.this, posts);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<responsemodel>> call, Throwable t) {

            }
        });

    }


    public void onClick(Dashboard dashboard) {
        Intent detailIntent =  new Intent(this,listmapel.class);
        detailIntent.putExtra("MAPEL",dashboard.getMapel());
        startActivity(detailIntent);
    }
}