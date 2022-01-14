package com.example.ofcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView logout;
    ImageView edit;

    TextView nama_pengguna, tvname, tvemail, tvphone;
    String name, email, phone;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManager = new SessionManager(ProfileActivity.this);
        if (sessionManager.isLoggedIn() == false){
            moveToLogin();
        }

        nama_pengguna = findViewById(R.id.nama_pengguna);
        name = sessionManager.getUserDetail().get(SessionManager.NAME);
        nama_pengguna.setText(name);

        tvname = findViewById(R.id.tvname);
//        name = sessionManager.getUserDetail().get(SessionManager.NAME);
        tvname.setText(name);

        tvemail = findViewById(R.id.tvemail);
        email = sessionManager.getUserDetail().get(SessionManager.EMAIL);
        tvemail.setText(email);

        tvphone = findViewById(R.id.tvphone);
        phone = sessionManager.getUserDetail().get(SessionManager.PHONE);
        tvphone.setText(phone);

        edit = findViewById(R.id.button_edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private  void moveToLogin(){
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();

    }
}