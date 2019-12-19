package com.example.siswa.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.siswa.R;

public class SettingActivity extends AppCompatActivity {

    private Switch toggleDM, toggleNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences("SETTINGS", MODE_PRIVATE);
        boolean useDarkMode = preferences.getBoolean("DARK_MODE", false);
        boolean useNotif = preferences.getBoolean("NOTIFICATION", false);

        if(useDarkMode) {
            setTheme(R.style.ActivityThemeDark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        toggleDM = findViewById(R.id.darkMode);
        toggleNotif = findViewById(R.id.notification);

        toggleDM.setChecked(useDarkMode);
        toggleNotif.setChecked(useNotif);

        toggleDM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                toggleDarkMode(isChecked);
            }
        });

        toggleNotif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                toggleNotification(isChecked);
            }
        });
    }

    private void toggleNotification(boolean notif) {
        SharedPreferences.Editor editor = getSharedPreferences("SETTINGS", MODE_PRIVATE).edit();
        editor.putBoolean("NOTIFICATION", notif);
        editor.apply();

        Intent intent = getIntent();
        finish();

        startActivity(intent);
        this.overridePendingTransition(0,0);
    }

    private void toggleDarkMode(boolean darkMode) {
        SharedPreferences.Editor editor = getSharedPreferences("SETTINGS", MODE_PRIVATE).edit();
        editor.putBoolean("DARK_MODE", darkMode);
        editor.apply();

        Intent intent = getIntent();
        finish();

        startActivity(intent);
        this.overridePendingTransition(0,0);
    }

    public void handleExit(View view) {
        finishAffinity();
        System.exit(0);
    }
}
