package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

    public static final String CHANNEL_ID = "com.example.ofcourse.CH01";

    RecyclerView recyclerView;
    MenuAdapter adapter;
    GridLayoutManager gridLayoutManager;
    List<ResponseMenu> menuList;

    ImageView profil;
    Button pemesanan, buttonNotifikasi, buttonGeolocation, buttonPencarian;

    TextView nama_profil;
    String name;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = findViewById(R.id.recview);
        menuList = new ArrayList<>();
        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        sessionManager = new SessionManager(MenuActivity.this);
        if (sessionManager.isLoggedIn() == false){
            moveToLogin();
        }

        nama_profil = findViewById(R.id.nama_profil);

        name = sessionManager.getUserDetail().get(SessionManager.NAME);

        nama_profil.setText(name);

        profil = findViewById(R.id.foto_profil);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


        buttonGeolocation = findViewById(R.id.buttonGeolocation);
        buttonGeolocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, current_loc.class);
                startActivity(intent);
            }
        });

        buttonPencarian = findViewById(R.id.buttonPencarian);
        buttonPencarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        pemesanan = findViewById(R.id.pemesanan);
        pemesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, sudah.class);
                startActivity(intent);
            }
        });

        buttonNotifikasi = findViewById(R.id.buttonNotifikasi);
        buttonNotifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
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

    private void displayNotification() {

        //Panggil Manager Notifikasi
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Buat Channel dan tambahkan ke Notification Manager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Channel Notifikasi ofCourse",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }

        //Buat pending Intent
        Intent menuIntent = new Intent(this, MenuActivity.class);

        PendingIntent menuPendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                12212,
                menuIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        //Bikin notifikasi
        Notification notif = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.iconpencarian)
                .setContentTitle("Promo Hari Guru")
                .setContentText("Potongan 70% hanya di minggu ini, voucher terbatas!")
                .setContentIntent(menuPendingIntent)
                .build();



        //Tampilkan notifikasinya
        notificationManager.notify(123, notif);

    }

    private  void moveToLogin(){
        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();

    }

}