package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class hasil_cari extends AppCompatActivity {
    ImageButton gurua;
    ImageButton buttonHome, buttonCari, buttonList, buttonProfile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_cari);
        gurua = findViewById(R.id.gurua);

    }
}