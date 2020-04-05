package com.example.topnotch;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

public class Renter extends AppCompatActivity {

    Button btnDel;
    Button btnPick;
    Button findCar;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        btnDel = findViewById(R.id.map_in);
        btnPick = findViewById(R.id.pick_time);
        findCar = findViewById(R.id.Find_in);
        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this, drawer , toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intPick = new Intent(Renter.this, Picker.class);
                startActivity(intPick);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intDel = new Intent(Renter.this, HomeTab.class);
                startActivity(intDel);
            }
        });

        findCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intFind = new Intent(Renter.this,Recycler.class);
                startActivity(intFind);

            }
        });

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }
}


