package com.example.siswa.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.siswa.R;
import com.example.siswa.Siswa;

public class lihat_detail_siswa extends AppCompatActivity {

    private TextView dtNama;
    private TextView dtEmail;
    private TextView dtNisn;
    private TextView dtHp;
    private TextView dtAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences("SETTINGS", MODE_PRIVATE);
        boolean useDarkMode = preferences.getBoolean("DARK_MODE", false);

        if (useDarkMode) {
            setTheme(R.style.ActivityThemeDark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_detail_siswa);
        dtNama = findViewById(R.id.namaTxt);
        dtEmail = findViewById(R.id.emailTxt);
        dtNisn= findViewById(R.id.nisnTxt);
        dtHp = findViewById(R.id.hpTxt);
        dtAlamat = findViewById(R.id.alamatTxt);

        Siswa siswa = (Siswa) getIntent().getSerializableExtra("dataSiswa");
        if(siswa!=null){
            dtNama.setText(siswa.getNama());
            dtEmail.setText(siswa.getEmail());
            dtNisn.setText(siswa.getNisn());
            dtHp.setText(siswa.getHp());
            dtAlamat.setText(siswa.getAlamat());
        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, lihat_detail_siswa.class);
    }
}
