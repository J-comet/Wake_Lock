package hs.project.wake_lock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnOpenWakeup(View view) {
        Intent openWakeup = new Intent(this, WakeupAlarmActivity.class);
        startActivity(openWakeup);
    }
    public void btnAlarmSetWakeup(View view) {
        setupAlarm();
    }

    private void setupAlarm() {
        Intent intentAlarmReceiver =new  Intent(this, AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intentAlarmReceiver, 0);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000 * 60, pendingIntent);

    }
}