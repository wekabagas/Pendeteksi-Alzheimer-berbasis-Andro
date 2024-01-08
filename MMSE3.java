package com.example.alzhes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MMSE3 extends AppCompatActivity {
    private long User;
    private Integer MMSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmse3);
        Calendar c = Calendar.getInstance();
        Button Next4 = findViewById(R.id.Next4);
        Spinner spinBln = findViewById(R.id.spinBln);
        Intent terima = getIntent();
        MMSE = Integer.parseInt(terima.getStringExtra("SkorMMSE"));
        Integer Bulan = c.get(Calendar.MONTH);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Bulan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinBln.setAdapter(adapter);
        spinBln.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                User = adapterView.getSelectedItemId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Bulan == User) {
                    MMSE++;
                }
                Intent Simpan = new Intent(MMSE3.this, MMSE4.class);
                Simpan.putExtra("SkorMMSE",String.valueOf(MMSE));
                startActivity(Simpan);
                Intent MMSE4 = new Intent(MMSE3.this, MMSE4.class);
                startActivity(MMSE4);
            }
        });
    }
}