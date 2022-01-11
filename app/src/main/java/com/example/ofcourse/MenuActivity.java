package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ofcourse.Model.ResponseGuru;
import com.example.ofcourse.Model.ResponseMenu;
import com.example.ofcourse.api.ApiClient;
import com.example.ofcourse.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import Adapter.GuruAdapter;
import Adapter.MenuAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    MenuAdapter adapter;
    GridLayoutManager gridLayoutManager;
    List<ResponseMenu> menuList;

    ImageView profil,pencarian;
    Button pemesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = findViewById(R.id.recview);
        menuList = new ArrayList<>();
        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

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

                Intent intent = new Intent(MenuActivity.this, riwayat_pesanan.class);
                startActivity(intent);
            }
        });


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<ResponseMenu>> call = apiInterface.getPost();
        call.enqueue(new Callback<List<ResponseMenu>>() {
            @Override
            public void onResponse(Call<List<ResponseMenu>> call, Response<List<ResponseMenu>> response) {

                if (!response.isSuccessful()){
                    return;
                }
                menuList = response.body();
                adapter = new MenuAdapter(menuList,MenuActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ResponseMenu>> call, Throwable t) {
                Log.d("TAG","onFailure"+t.getLocalizedMessage());
            }
        });
    }

}