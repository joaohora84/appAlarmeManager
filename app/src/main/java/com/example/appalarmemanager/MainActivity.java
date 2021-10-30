package com.example.appalarmemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disparar(View view) {

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent i = new Intent(this, MyBroadcast.class);

        pendingIntent = PendingIntent.getBroadcast(this, 0, i, 0);

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 11);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + 5*1000, pendingIntent);

    }
}