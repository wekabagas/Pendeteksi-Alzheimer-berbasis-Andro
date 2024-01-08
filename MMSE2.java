package com.example.alzhes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.temporal.ValueRange;
import java.util.Calendar;

public class MMSE2 extends AppCompatActivity {
    private Integer MMSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmse2);
        Calendar c = Calendar.getInstance();
        Integer Tahun = c.get(Calendar.YEAR);
        Button Next3 = findViewById(R.id.Next3);
        EditText ETahun = findViewById(R.id.editThn);
        Intent terima = getIntent();
        MMSE = Integer.parseInt(terima.getStringExtra("SkorMMSE"));
        Next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ETahun.getText().toString().trim().equals("")) {
                    ETahun.setError("Jawaban tidak boleh kosong");
                }
                else {
                    if (Tahun == Integer.parseInt(ETahun.getText().toString())) {
                        MMSE++;
                    }
                    Intent Simpan = new Intent(MMSE2.this, MMSE3.class);
                    Simpan.putExtra("SkorMMSE", String.valueOf(MMSE));
                    startActivity(Simpan);
                    Intent MMSE3 = new Intent(MMSE2.this, MMSE3.class);
                    startActivity(MMSE3);
                }
            }
        });
    }
}