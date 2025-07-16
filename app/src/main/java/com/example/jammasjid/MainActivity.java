package com.example.jammasjid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvCurrentTime, tvNextPrayer;
    private Handler handler = new Handler(Looper.getMainLooper());
    private PrayerManager prayerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCurrentTime = findViewById(R.id.tvCurrentTime);
        tvNextPrayer = findViewById(R.id.tvNextPrayer);

        prayerManager = new PrayerManager(this);
        updateTime();
        prayerManager.scheduleAllPrayerAlarms(); // Menjadwalkan adzan & iqamah
    }

    private void updateTime() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String time = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
                tvCurrentTime.setText(time);
                handler.postDelayed(this, 1000);
            }
        }, 0);
    }
}
