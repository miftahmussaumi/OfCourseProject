package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reservasiselesai extends AppCompatActivity {

    Button buttonselesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservasiselesai);

        buttonselesai = findViewById(R.id.buttonselesai);
        buttonselesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Reservasiselesai.this, dashboard.class);
                startActivity(intent);

            }

        });
    }
}