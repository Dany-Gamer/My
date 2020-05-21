package com.example.topnotch;

import android.content.Intent;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class booking extends AppCompatActivity {
    Button btnPay,btnInfo1,btnInfo2;
    ImageView img2;
    double price;
    String img;
    String name;
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        notificationManager = NotificationManagerCompat.from(this);

        btnPay = findViewById((R.id.btnforPay));
        btnInfo1 = findViewById(R.id.btnforInfo1);
        btnInfo2 = findViewById(R.id.btnforinfo2);
        name = getIntent().getStringExtra("name");
        price = getIntent().getDoubleExtra("price",0);
        btnInfo1.setText(name);
        btnInfo2.setText(String.valueOf(price));
        img2 = findViewById(R.id.image2);
        img = getIntent().getStringExtra("img");
        Picasso.get().load(img).into(img2);
      btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentPay = new Intent(booking.this, Payment.class);
                intentPay.putExtra("name",name);
                startActivity(intentPay);
            }
        });


    }



}
