package com.harshadachavan.boundservice;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void playAudio(View view) {
        Intent serviceIntent = new Intent(this, UnboundMyService.class);
        startService(serviceIntent);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        Intent intent = getIntent();
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);

        builder.setContentTitle("Music Running");
        builder.setContentText("Your song is playing");
        builder.setSubText("Tap to go to activity");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Will display the notification in the notification bar
        notificationManager.notify(1, builder.build());

    }

    public void stopAudio(View view) {
        Intent serviceIntent = new Intent(this, UnboundMyService.class);
        stopService(serviceIntent);
    }
}
