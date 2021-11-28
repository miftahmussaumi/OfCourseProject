package com.example.ofcourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class beri_review extends AppCompatActivity {
    Button button_berikanpenilaian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        button_berikanpenilaian = findViewById(R.id.button_berikanpenilaian);


        button_berikanpenilaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(beri_review.this, review_berhasil.class);
                startActivity(intent);
            }
        });


    }
}
