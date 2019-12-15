package com.example.siswa.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import com.example.siswa.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.DarkTheme);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Membaca file menu dan menambahkan isinya ke action bar jika ada.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    public void onComposeAction(MenuItem mi) {
        setContentView(R.layout.activity_setting);
    }
    public void handleTambahData(View view) {
        Intent intent = new Intent(this, tambahSiswa.class);
        startActivity(intent);
    }

    public void handleLihatData(View view) {
        Intent intent = new Intent(this, lihatSiswa.class);
        startActivity(intent);
    }

    public void handleExit(View view) {
        finish();
    }
}
