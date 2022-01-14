package com.example.ofcourse;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class AppNotificationService extends FirebaseMessagingService {

    public static final String CHANNEL_ID = "com.example.ofcourse.CH01";

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.d("fcm-token", s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();

        //tampilkan notifikasi
        displayNotification(title, message);

    }

    private void displayNotification(String title, String message) {

        //Panggil Manager Notifikasi
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Buat Channel dan tambahkan ke Notification Manager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Channel Notifikasi ofCourse",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }

        //Buat pending Intent
        Intent menuIntent = new Intent(getApplicationContext(), MenuActivity.class);

        PendingIntent menuPendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                12212,
                menuIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        //Bikin notifikasi
        Notification notif = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.iconpencarian)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(menuPendingIntent)
                .build();


        //Tampilkan notifikasinya
        notificationManager.notify(123, notif);

    }
}