package com.example.siswa.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.siswa.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tambahSiswa extends AppCompatActivity {

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnNext;

    private EditText namaInput;
    private EditText emailInput;
    private EditText nisnInput;
    private EditText hpInput;
    private EditText alamatInput;

    String namaStr, emailStr, nisnStr, hpStr, alamatStr;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_siswa);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        viewPager = findViewById(R.id.view_pager);
        dotsLayout = findViewById(R.id.layoutDots);
        btnNext = findViewById(R.id.next);

        layouts = new int[]{
                R.layout.fragment_data1,
                R.layout.fragment_data2,
                R.layout.fragment_data3 };

        addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);

                } else {
                    launchHomeScreen();
                    addData();
                }
            }
        });
    }

    private void addData(){
        namaStr = namaInput.getText().toString();
        emailStr = emailInput.getText().toString();
        nisnStr = nisnInput.getText().toString();
        hpStr = hpInput.getText().toString();
        alamatStr = alamatInput.getText().toString();

        final Notification.Builder builder = new Notification.Builder(tambahSiswa.this)
                .setTicker("TickerTitle")
                .setContentTitle("Data Siswa")
                .setContentText("Data siswa berhasil ditambahkan")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_background);

        if (!namaStr.isEmpty() && !emailStr.isEmpty() && !nisnStr.isEmpty() && !hpStr.isEmpty() && !alamatStr.isEmpty()){
            DatabaseReference newData = mDatabase.child("dataSiswa").push();
            newData.child("nama").setValue(namaStr);
            newData.child("email").setValue(emailStr);
            newData.child("nisn").setValue(nisnStr);
            newData.child("hp").setValue(hpStr);
            newData.child("alamat").setValue(alamatStr).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {

                    NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(0, builder.build());

                }
            });
        }
        else {
            Toast.makeText(this, "Data Gagal Ditambahkan", Toast.LENGTH_LONG).show();
        }
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        startActivity(new Intent(tambahSiswa.this, MainActivity.class));
        finish();
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.finish));
//                btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                btnNext.setText(getString(R.string.next));
//                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            if (layouts[position]== R.layout.fragment_data1){
                namaInput = view.findViewById(R.id.nama_text);
                emailInput = view.findViewById(R.id.email_text);
            }

            if (layouts[position]==R.layout.fragment_data2){
                nisnInput = view.findViewById(R.id.nisn_text);
                hpInput = view.findViewById(R.id.hp_text);
            }

            if (layouts[position]==R.layout.fragment_data3){
                alamatInput = view.findViewById(R.id.alamat_text);
            }
//            System.out.println("ini view ke"+layouts[position] +" = "+ view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
