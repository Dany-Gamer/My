package com.example.topnotch;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;

import static com.example.topnotch.CreateChannel.CHANNEL_ID;

public class Payment extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
        String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        notificationManager = NotificationManagerCompat.from(this);
        name = (getIntent().getStringExtra("name"));
    }


    public void showNotification(View view) {
        RemoteViews collapsedView = new RemoteViews(getPackageName(),
                R.layout.notification_collapse);

        collapsedView.setTextViewText(R.id.text_view_collapsed_1, name);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_directions_car_black_24dp)
                .setCustomContentView(collapsedView)
                .build();

        notificationManager.notify(1, notification);

    }

}
