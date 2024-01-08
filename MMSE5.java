package com.example.alzhes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MMSE5 extends AppCompatActivity {
    private Integer MMSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmse5);
        Calendar c = Calendar.getInstance();
        Integer Tanggal = c.get(Calendar.DATE);
        Button Next6 = findViewById(R.id.Next6);
        EditText ETgl = findViewById(R.id.editTgl);
        Intent terima = getIntent();
        MMSE = Integer.parseInt(terima.getStringExtra("SkorMMSE"));
        Next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ETgl.getText().toString().trim().equals("")) {
                    ETgl.setError("Jawaban tidak boleh kosong");
                }
                else {
                    if (Tanggal == Integer.parseInt(ETgl.getText().toString())) {
                        MMSE++;
                    }
                    Intent Simpan = new Intent(MMSE5.this, MMSE6.class);
                    Simpan.putExtra("SkorMMSE", String.valueOf(MMSE));
                    startActivity(Simpan);
                    Intent MMSE6 = new Intent(MMSE5.this, com.example.alzhes.MMSE6.class);
                    startActivity(MMSE6);
                }
            }
        });
    }
}