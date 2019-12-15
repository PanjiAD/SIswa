package com.example.siswa.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import com.example.siswa.R;

public class Setting extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (InitApplication.getInstance().isNightModeEnabled()) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }
//
//        setContentView(R.layout.activity_setting);
//
//        SwitchCompat switchCompat = findViewById(R.id.switchCompat);
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AlertDialog.Builder(Setting.this, R.style.MyDialog)
//                        .setTitle("Title")
//                        .setMessage("Message")
//                        .show();
//            }
//        });
//
//        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
//            switchCompat.setChecked(true);
//
//        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    InitApplication.getInstance().setIsNightModeEnabled(true);
//                    Intent intent = getIntent();
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    finish();
//                    startActivity(intent);
//
//                } else {
//                    InitApplication.getInstance().setIsNightModeEnabled(false);
//                    Intent intent = getIntent();
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    finish();
//                    startActivity(intent);
//                }
//
//
//            }
//        });
//
//    }
}
