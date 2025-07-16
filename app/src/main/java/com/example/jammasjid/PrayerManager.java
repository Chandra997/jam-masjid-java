package com.example.jammasjid;

import java.util.Calendar;
import android.content.Context;
import java.util.List;




public class PrayerManager {
    private Context context;

    public PrayerManager(Context context) {
        this.context = context;
    }

    public void scheduleAllPrayerAlarms() {
        // Lokasi default bisa diganti dengan lokasi dinamis
        double latitude = -6.2;
        double longitude = 106.8;

        Calendar today = Calendar.getInstance();
        PrayTimeCalculator prayTime = new PrayTimeCalculator();
        prayTime.setTimeFormat(PrayTimeCalculator.TIME_24);
        prayTime.setCalcMethod(PrayTimeCalculator.MWL);
        List<String> times = prayTime.getPrayerTimes(today, latitude, longitude, 7.0);


        String[] prayerNames = {"Fajr", "Sunrise", "Dhuhr", "Asr", "Maghrib", "Isha"};
        for (int i = 0; i < prayerNames.length; i++) {
            String timeStr = times.get(i); // Format HH:mm
            AlarmHelper.schedulePrayerAlarm(context, prayerNames[i], timeStr);
        }
    }
}
