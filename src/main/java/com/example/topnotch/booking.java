package com.example.topnotch;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class booking extends AppCompatActivity {
    Button btnPay,btnInfo1,btnInfo2;
    ImageView img2;
    double price2;
    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        btnPay = findViewById((R.id.btnforPay));
        btnInfo1 = findViewById(R.id.btnforInfo1);
        btnInfo2 = findViewById(R.id.btnforinfo2);
        btnInfo1.setText(getIntent().getStringExtra("name"));
        btnInfo2.setText(String.valueOf(getIntent().getDoubleExtra("price",price2)));
        img2 = findViewById(R.id.image2);
        img = getIntent().getStringExtra("img");
        Picasso.get().load(img).into(img2);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPay = new Intent(booking.this,payment.class);
                startActivity(intentPay);
            }
        });
    }
}
