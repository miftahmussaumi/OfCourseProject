package com.example.ofcourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ofcourse.Model.register.Register;
import com.example.ofcourse.api.ApiClient;
import com.example.ofcourse.api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText daftarNama, daftarPassword, daftarEmail, daftarPhone;
    Button btndaftar;
//    TextView tvLogin;
    String Email, Phone, Password, Name;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        daftarNama = findViewById(R.id.daftarNama);
        daftarEmail = findViewById(R.id.daftarEmail);
        daftarPhone = findViewById(R.id.daftarPhone);
        daftarPassword = findViewById(R.id.daftarPassword);
        btndaftar = findViewById(R.id.btndaftar);
        btndaftar.setOnClickListener(this);

//        tvLogin = findViewById(R.id.tvLoginHere);
//        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btndaftar:
                Name = daftarNama.getText().toString();
                Email = daftarEmail.getText().toString();
                Password = daftarPassword.getText().toString();
                Phone = daftarPhone.getText().toString();
                register(Name, Email, Phone, Password);
                break;

        }
    }

    private void register(String name, String email, String phone, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Register> call = apiInterface.registerResponse(name, email, phone, password);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}