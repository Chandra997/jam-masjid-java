package com.example.jammasjid;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.widget.Toast;

public class PrayerTimeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String prayer = intent.getStringExtra("prayer");
        String type = intent.getStringExtra("type");


        String message = (type.equals("adzan")) ? "Waktu " + prayer + " telah tiba (Adzan)" :
                "Segera Iqamah untuk " + prayer;

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

        // Bisa tambahkan suara adzan di sini jika diperlukan
    }
}
