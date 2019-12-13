package com.example.siswa.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.siswa.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleTambahData(View view) {
        Intent intent = new Intent(this, tambahSiswa.class);
        startActivity(intent);
    }

    public void handleLihatData(View view) {
        Intent intent = new Intent(this, lihatSiswa.class);
        startActivity(intent);
    }
}
