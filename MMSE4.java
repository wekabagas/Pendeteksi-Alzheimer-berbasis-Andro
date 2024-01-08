package com.example.alzhes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MMSE4 extends AppCompatActivity {
    private long User;
    private Integer MMSE, Hari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmse4);
        Calendar c = Calendar.getInstance();
        Button Next5 = findViewById(R.id.Next5);
        Spinner spinHari = findViewById(R.id.spinHari);
        Intent terima = getIntent();
        MMSE = Integer.parseInt(terima.getStringExtra("SkorMMSE"));
        Hari = c.get(Calendar.DAY_OF_WEEK); Hari--;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Hari, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinHari.setAdapter(adapter);
        spinHari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                User = adapterView.getSelectedItemId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Hari == User) {
                    MMSE++;
                }
                Intent Simpan = new Intent(MMSE4.this, MMSE5.class);
                Simpan.putExtra("SkorMMSE", String.valueOf(MMSE));
                startActivity(Simpan);
                Intent MMSE5 = new Intent(MMSE4.this, com.example.alzhes.MMSE5.class);
                startActivity(MMSE5);
            }
        });
    }
}