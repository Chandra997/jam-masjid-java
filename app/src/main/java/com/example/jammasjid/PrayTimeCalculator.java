package com.example.jammasjid;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PrayTimeCalculator {

    public static final int TIME_24 = 0;
    public static final int MWL = 3;

    private int timeFormat = TIME_24;
    private int calcMethod = MWL;

    public void setTimeFormat(int format) {
        this.timeFormat = format;
    }

    public void setCalcMethod(int method) {
        this.calcMethod = method;
    }

    public List<String> getPrayerTimes(Calendar date, double latitude, double longitude, double timezone) {
        // Simulasi waktu sholat (dummy), harus diganti dengan perhitungan sebenarnya
        List<String> times = new ArrayList<>();
        times.add("04:30"); // Fajr
        times.add("05:45"); // Sunrise
        times.add("12:00"); // Dhuhr
        times.add("15:15"); // Asr
        times.add("17:45"); // Maghrib
        times.add("19:00"); // Isha
        return times;
    }
}
