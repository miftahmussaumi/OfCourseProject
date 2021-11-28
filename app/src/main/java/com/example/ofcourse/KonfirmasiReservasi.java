package com.example.ofcourse;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KonfirmasiReservasi extends AppCompatActivity {

    Button buttonlanjut;
    ActionBar actionBar;
    private String notr, mapel, biaya, guru, tgl, jam, durasi, jml, lokasi, ket, total;
    private TextView knotr, kmapel, kbiaya, kguru, ktgl, kjam, kdurasi, kjml, klokasi, kket, ktotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_reservasi);

        Bundle konfirmasi = getIntent().getExtras();
        notr = konfirmasi.getString("ntr");
        mapel = konfirmasi.getString("mapel");
        biaya = konfirmasi.getString("biaya");
        guru = konfirmasi.getString("guru");
        tgl = konfirmasi.getString("tgl");
        jam = konfirmasi.getString("jam");
        durasi = konfirmasi.getString("durasi");
        jml = konfirmasi.getString("jml");
        lokasi = konfirmasi.getString("lokasi");
        ket = konfirmasi.getString("ket");
        total = konfirmasi.getString("total");

        knotr = findViewById(R.id.knotr);
        kmapel = findViewById(R.id.kmapel);
        kbiaya = findViewById(R.id.kbiaya);
        kguru = findViewById(R.id.kguru) ;
        ktgl = findViewById(R.id.ktgl);
        kjam = findViewById(R.id.kjam);
        kdurasi = findViewById(R.id.kdurasi);
        kjml = findViewById(R.id.kjumlah) ;
        klokasi = findViewById(R.id.klokasi);
        kket = findViewById(R.id.kket);
        ktotal = findViewById(R.id.ktotal);

        knotr.setText(notr);
        kmapel.setText(mapel);
        kbiaya.setText(biaya);
        kguru.setText(guru);
        ktgl.setText(tgl);
        kjam.setText(jam);
        kdurasi.setText(durasi);
        kjml.setText(jml);
        klokasi.setText(lokasi);
        kket.setText(ket);
        ktotal.setText(total);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonlanjut = findViewById(R.id.buttonlanjut);
        buttonlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(KonfirmasiReservasi.this, Reservasiselesai.class);
                startActivity(intent);

            }
        });

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
}