package com.example.ofcourse;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Formreservasi extends AppCompatActivity {

    Button button1;
    ActionBar actionBar;
    private TextView notr;
    private TextView mapel;
    private TextView biaya;
    private TextView guru;
    private EditText tgl;
    private EditText jam;
    private EditText durasi;
    private EditText jml;
    private EditText lokasi;
    private EditText ket;
    private String mpl, bia, gru;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formreservasi);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button1 = findViewById(R.id.buttonpesan);
        notr = (TextView) findViewById(R.id.formnotr);
        mapel = (TextView) findViewById(R.id.formmapel);
        biaya = (TextView) findViewById(R.id.formbiaya);
        guru = (TextView) findViewById(R.id.formguru);
        tgl = (EditText) findViewById(R.id.formtgl);
        jam = (EditText) findViewById(R.id.formjam);
        durasi = (EditText) findViewById(R.id.formdurasi);
        jml = (EditText) findViewById(R.id.formjumlah);
        lokasi = (EditText) findViewById(R.id.formlokasi);
        ket = (EditText) findViewById(R.id.formket);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Formreservasi.this, KonfirmasiReservasi.class);
                intent.putExtra("ntr", notr.getText().toString());
                intent.putExtra("mapel", mapel.getText().toString());
                intent.putExtra("biaya", biaya.getText().toString());
                intent.putExtra("guru", guru.getText().toString());
                intent.putExtra("tgl", tgl.getText().toString());
                intent.putExtra("jam", jam.getText().toString());
                intent.putExtra("durasi", durasi.getText().toString());
                intent.putExtra("jml", jml.getText().toString());
                intent.putExtra("lokasi", lokasi.getText().toString());
                intent.putExtra("ket", ket.getText().toString());
                startActivity(intent);

            }

        });

        Bundle form = getIntent().getExtras();
        mpl = form.getString("mapel");
        bia = form.getString("biaya");
        gru = form.getString("namaguru");

        mapel = findViewById(R.id.formmapel);
        biaya = findViewById(R.id.formbiaya);
        guru = findViewById(R.id.formguru);

        mapel.setText(mpl);
        biaya.setText(bia);
        guru.setText(gru);
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