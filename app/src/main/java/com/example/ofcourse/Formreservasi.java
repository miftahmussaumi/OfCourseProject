package com.example.ofcourse;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ofcourse.Model.Reservasi;
import com.example.ofcourse.Model.register.Register;
import com.example.ofcourse.api.ApiClient;
import com.example.ofcourse.api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Formreservasi extends AppCompatActivity implements View.OnClickListener {

    TextView formidguru, formidmapel, formidusers;
    Button buttonpesan;
    ActionBar actionBar;
     EditText tgl;
     EditText jam;
     EditText durasi;
     EditText lokasi;
     EditText ket;

    String Tgl;
    String Jam_kls;
    String Lokasi_kls;
    String Ket_tambahan;

    Integer id_users, id_guru, id_mapel;
    Integer   Id_mapel;
    Integer Id_guru;
    Integer Durasi;
    Integer Id_users;
    ApiInterface apiInterface;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formreservasi);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sessionManager = new SessionManager(Formreservasi.this);
        if (sessionManager.isLoggedIn() == false){
            moveToLogin();
        }

//         Id_users = Integer.valueOf(sessionManager.getUserDetail().get(SessionManager.ID));

//        id_mapel = findViewById(R.id.formidmapel);
//
//        Id_user =findViewById(R.id.formidusers);
//        Id_user = sessionManager.getUserDetail().get(SessionManager.ID);

        Bundle form = getIntent().getExtras();

        formidguru = findViewById(R.id.formidguru);
        Id_guru = form.getInt("d_idguru");
        formidguru.setText(String.valueOf(Id_guru));

        formidmapel = findViewById(R.id.formidmapel);
        Id_mapel = form.getInt("d_idmapel");
        formidmapel.setText(String.valueOf(Id_mapel));

        formidusers = findViewById(R.id.formidusers);
        Id_users = Integer.valueOf(sessionManager.getUserDetail().get(SessionManager.ID));
        formidusers.setText(String.valueOf(Id_users));

        tgl = findViewById(R.id.formtgl);
        jam = findViewById(R.id.formjam);
        durasi = findViewById(R.id.formdurasi);
        lokasi = findViewById(R.id.formlokasi);
        ket = findViewById(R.id.formket);

//        Bundle form = getIntent().getExtras();
//        Id_guru = form.getInt("d_idguru");
//        Id_mapel = form.getInt("id_mapel");

        buttonpesan = findViewById(R.id.buttonpesan);
        buttonpesan.setOnClickListener(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonpesan:
                Tgl = tgl.getText().toString();
                Jam_kls = jam.getText().toString();
//                String dr =durasi.getText().toString();
//                Durasi = Integer.parseInt(dr);
                Durasi = Integer.valueOf(String.valueOf(durasi.getText()));
                Lokasi_kls = lokasi.getText().toString();
                Ket_tambahan = ket.getText().toString();;
                Bundle form = getIntent().getExtras();
                Id_guru = form.getInt("d_idguru");
                Id_mapel = form.getInt("d_idmapel");
                Id_users = Integer.valueOf(sessionManager.getUserDetail().get(SessionManager.ID));

                id_guru = Id_guru;
//                id_mapel = Id_mapel;
                id_users = Id_users;
                pesan(Id_guru, Id_users,Tgl,Jam_kls,Durasi,Lokasi_kls,Ket_tambahan);
                break;
        }
    }

    private void pesan(Integer id_guru, Integer id_users,String tgl, String jam_kls, Integer durasi, String lokasi_kls, String ket_tambahan){

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
      Call<Reservasi> call = apiInterface.ReservasiResponse(id_guru, id_users,tgl, jam_kls, durasi,lokasi_kls,ket_tambahan);
      call.enqueue(new Callback<Reservasi>() {
            @Override
            public void onResponse(Call<Reservasi> call, Response<Reservasi> response) {
//                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
//                    Toast.makeText(Formreservasi.this, response.body(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Formreservasi.this, Reservasiselesai.class);
                    startActivity(intent);
                    finish();
//                } else {
//                    Toast.makeText(Formreservasi.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        Intent intent = new Intent(Formreservasi.this, Reservasiselesai.class);
        startActivity(intent);
    }

    private  void moveToLogin(){
        Intent intent = new Intent(Formreservasi.this, LoginActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();

    }
}