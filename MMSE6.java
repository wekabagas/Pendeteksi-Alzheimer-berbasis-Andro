package com.example.alzhes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.CarrierConfigManager;

public class MMSE6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmse6);
        if (ActivityCompat.checkSelfPermission(My_location.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(My_location.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(My_location.this, new String[]{ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }
    }
}