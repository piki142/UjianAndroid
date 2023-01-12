package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNamaDepan = (EditText) findViewById(R.id.edNamaDepan);
        EditText edNamaBelakang = (EditText) findViewById(R.id.edNamaBelakang);
        EditText inpUmur = (EditText) findViewById(R.id.inpUmur);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama_depan = edNamaDepan.getText().toString();
                String isian_nama_belakang = edNamaBelakang.getText().toString();
                String isian_umur = inpUmur.getText().toString();

                if(isian_nama_depan.isEmpty() && isian_nama_belakang.isEmpty() && isian_umur.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                }else {
                    Integer umur = Integer.valueOf(isian_umur);
                    String nama_lengkap = isian_nama_depan.concat(" ").concat(isian_nama_belakang).concat(", ").concat("Status : ");
                    daftar_nama.clear();
                    for(Integer i = 1; i <= umur; i++) {
                        if(umur >= 1 && umur <= 10) {
                            daftar_nama.add( i + " " +  nama_lengkap.concat("Anak"));
                        } else if(umur >= 11 && umur <= 20) {
                            daftar_nama.add( i + " " +  nama_lengkap.concat("Remaja"));
                        } else if(umur >= 21 && umur <= 40) {
                            daftar_nama.add( i + " " +  nama_lengkap.concat("Dewasa"));
                        } else {
                            daftar_nama.add( i + " " +  nama_lengkap.concat("Tua"));
                        }
                        edNamaDepan.setText("");
                        edNamaBelakang.setText("");
                        intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                        startActivity(intent_list);
                    }
                }
            }
        });
    }
}