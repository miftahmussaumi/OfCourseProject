package com.example.ofcourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pesanan_disetujui extends AppCompatActivity {

    Button buttonselesai2, buttonsedangdiproses2, button_nilai2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_telah_disetujui);

        buttonselesai2 = findViewById(R.id.buttonselesai2);
        buttonsedangdiproses2 = findViewById(R.id.buttonsedangdiproses2);
        button_nilai2 =  findViewById(R.id.button_nilai2);

        buttonselesai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(pesanan_disetujui.this, pesanan_disetujui.class);
                startActivity(intent);
            }
        });

        buttonsedangdiproses2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(pesanan_disetujui.this, pesanan_belum_disetujui.class);
                startActivity(intent);
            }
        });

        button_nilai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(pesanan_disetujui.this, beri_review.class);
                startActivity(intent);
            }
        });
    }
}