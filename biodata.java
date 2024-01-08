package com.example.alzhes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Biodata extends AppCompatActivity {
    private EditText ENama, ETTl, EUsia, EEmail;
    private Button Next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        ENama = findViewById(R.id.EditNama);
        ETTl = findViewById(R.id.EditTTL);
        EUsia = findViewById(R.id.EditUsia);
        EEmail = findViewById(R.id.EditEmail);
        Next1 = findViewById(R.id.Next1);
        Next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((ENama.getText().toString()).trim().equals("")) {
                    ENama.setError("Nama tidak boleh kosong");
                }
                else if ((ETTl.getText().toString()).trim().equals("")) {
                    ETTl.setError("Tanggal lahir tidak boleh kosong");
                }
                else if ((EUsia.getText().toString()).trim().equals("")) {
                    EUsia.setError("Usia tidak boleh kosong");
                }
                else if ((EEmail.getText().toString()).trim().equals("")) {
                    EEmail.setError("Isikan email dengan benar");
                }
                else {
                    showDialog();
                }
            }
        });
    }
    private void showDialog () {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Mulai Test ?");
        alertDialogBuilder.setMessage("Apakah anda siap memulai test ? Pastikan anda menjawab semua pertanyaan dengan jujur untuk mendapatkan hasil yang sesuai");
        alertDialogBuilder.setIcon(R.drawable.logo);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent MMSE1 = new Intent(Biodata.this, MMSE1.class);
                startActivity(MMSE1);
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
