package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class pencarian extends AppCompatActivity {
    ImageButton gurua, buttonMap;
    ImageButton buttonHome, buttonCari, buttonList, buttonProfile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);

        gurua = findViewById(R.id.gurua);
        buttonMap = findViewById(R.id.buttonMap);


    }
}