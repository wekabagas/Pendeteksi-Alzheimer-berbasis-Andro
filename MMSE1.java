package com.example.alzhes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class MMSE1 extends AppCompatActivity {
    private Integer Musim, User, MMSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmse1);
        Calendar c = Calendar.getInstance();
        MMSE = 0;
        Button Next2 = findViewById(R.id.Next2);
        RadioButton Hujan = findViewById(R.id.RBMusim1);
        Hujan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Hujan.isChecked()) {
                    User = 0; // Musim Hujan
                }
            }
        });
        RadioButton Kemarau = findViewById(R.id.RBMusim2);
        Kemarau.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Kemarau.isChecked()) {
                    User = 1; // Musim Kemarau
                }
            }
        });
        String[]NamaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        String Bulan = NamaBulan[c.get(Calendar.MONTH)];
        Integer Bln = c.get(Calendar.MONTH);
        if (Bln < 3) {
            Musim = 0; // Musim Hujan
        }
        else if (Bln > 8) {
            Musim = 0; // Musim Hujan
        }
        else {
            Musim = 1; // Musim Kemarau
        }
        Next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Musim == User) {
                    MMSE++;
                }
                Intent Simpan = new Intent(MMSE1.this, MMSE2.class);
                Simpan.putExtra("SkorMMSE",String.valueOf(MMSE));
                startActivity(Simpan);
                Intent MMSE2 = new Intent(MMSE1.this,MMSE2.class);
                startActivity(MMSE2);
            }
        });
    }
}