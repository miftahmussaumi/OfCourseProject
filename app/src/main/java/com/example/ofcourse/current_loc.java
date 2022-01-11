package com.example.ofcourse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class current_loc extends AppCompatActivity {

    Button btnLocation;
    TextView text1, text2, text3, text4, text5;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_loc);

        btnLocation = findViewById(R.id.bt_loc);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(current_loc.this
                        , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(current_loc.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location!=null){
                    try {
                        Geocoder geocoder =  new Geocoder(current_loc.this,
                                Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(
                          location.getLatitude(),location.getLongitude(),1
                        );
                        //Set Latitude
                        text1.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Latitude : </b><br></font>"
                                +addresses.get(0).getLatitude()
                        ));
                        //Set Longitude
                        text2.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Longitude : </b><br></font>"
                                        +addresses.get(0).getLongitude()
                        ));
                        //Set Country
                        text3.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Country Name : </b><br></font>"
                                        +addresses.get(0).getCountryName()
                        ));
                        //Set Locality
                        text4.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Locality : </b><br></font>"
                                        +addresses.get(0).getLocality()
                        ));
                        //Set Addresses
                        text5.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Addresses : </b><br></font>"
                                        +addresses.get(0).getAddressLine(0)
                        ));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}