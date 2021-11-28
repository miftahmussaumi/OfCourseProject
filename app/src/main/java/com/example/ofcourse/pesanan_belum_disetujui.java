package com.example.ofcourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pesanan_belum_disetujui extends AppCompatActivity {

    Button buttonselesai, buttonsedangdiproses;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_belum_disetujui);

        buttonselesai = findViewById(R.id.buttonselesai);
        buttonsedangdiproses = findViewById(R.id.buttonsedangdiproses);

        buttonselesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(pesanan_belum_disetujui.this, pesanan_disetujui.class);
                startActivity(intent);
            }
        });

        buttonsedangdiproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(pesanan_belum_disetujui.this, pesanan_belum_disetujui.class);
                startActivity(intent);
            }
        });

    }
}