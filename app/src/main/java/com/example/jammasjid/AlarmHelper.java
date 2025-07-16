package com.example.jammasjid;

import android.content.Context;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;




public class AlarmHelper {

    public static void schedulePrayerAlarm(Context context, String prayerName, String timeStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
            Date date = format.parse(timeStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.SECOND, 0);

            // Jadwal Adzan
            Intent adzanIntent = new Intent(context, PrayerTimeReceiver.class);
            adzanIntent.putExtra("prayer", prayerName);
            adzanIntent.putExtra("type", "adzan");

            PendingIntent adzanPI = PendingIntent.getBroadcast(context, prayerName.hashCode(), adzanIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmMgr.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), adzanPI);

            // Jadwal Iqamah 5 menit kemudian
            cal.add(Calendar.MINUTE, 5);
            Intent iqamahIntent = new Intent(context, PrayerTimeReceiver.class);
            iqamahIntent.putExtra("prayer", prayerName);
            iqamahIntent.putExtra("type", "iqamah");

            PendingIntent iqamahPI = PendingIntent.getBroadcast(context, (prayerName + "iqamah").hashCode(), iqamahIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmMgr.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), iqamahPI);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

