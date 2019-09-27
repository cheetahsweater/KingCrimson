package com.example.kingcrimson;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.SystemClock;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static Context context;

    private void setActive(ToggleButton button){
        Chronometer simpleChronometer = findViewById(R.id.simpleChronometer);
        ProgressBar progressbar = findViewById(R.id.progressBar);
        button.setBackgroundResource(R.mipmap.trang2);
        button.setTextColor(Color.BLACK);
        simpleChronometer.setBase(SystemClock.elapsedRealtime());
        simpleChronometer.start();
        simpleChronometer.setVisibility(View.VISIBLE);
        progressbar.setVisibility(View.VISIBLE);
        progressbar.bringToFront();
    }
    private void setInactive(ToggleButton button) {
        Chronometer simpleChronometer = findViewById(R.id.simpleChronometer);
        Toast.makeText(MainActivity.this, "We live on a placid island of ignorance in the midst of black seas of infinity, and it was not meant that we should voyage far.", Toast.LENGTH_SHORT).show();
        ProgressBar progressbar = findViewById(R.id.progressBar);
        button.setBackgroundResource(R.mipmap.trang1);
        button.setTextColor(Color.BLACK);
        simpleChronometer.stop();
        simpleChronometer.setVisibility(View.VISIBLE);
        progressbar.setVisibility(View.INVISIBLE);
        Toast.makeText(MainActivity.this, "bruh", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Chronometer simpleChronometer = findViewById(R.id.simpleChronometer);
        ToggleButton button;
        MainActivity.context=getApplicationContext();
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.mammioux);
        mediaPlayer.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleChronometer.setBase(SystemClock.elapsedRealtime());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.button1);
        Chronometer simpleChronometer2 = findViewById(R.id.simpleChronometer2);
        simpleChronometer.stop();
        simpleChronometer2.stop();
        ProgressBar progressbar = findViewById(R.id.progressBar);
        ProgressBar progressbar2 = findViewById(R.id.progressBar2);
        progressbar.setVisibility(View.INVISIBLE);
        progressbar2.setVisibility(View.INVISIBLE);
        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ToggleButton button = findViewById(R.id.button1);
                ToggleButton button2 = findViewById(R.id.button2);
                ProgressBar progressbar = findViewById(R.id.progressBar);
                ProgressBar progressbar2 = findViewById(R.id.progressBar2);
                progressbar2.setVisibility(View.INVISIBLE);
                if (isChecked) {
                    setActive(button);
                } else {
                    setInactive(button);
                }
            }
        });
        button = findViewById(R.id.button2);

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ToggleButton button = findViewById(R.id.button2);
                ToggleButton button2 = findViewById(R.id.button1);
                Chronometer simpleChronometer = findViewById(R.id.simpleChronometer2);
                Chronometer simpleChronometer2 = findViewById(R.id.simpleChronometer);
                ProgressBar progressbar = findViewById(R.id.progressBar2);
                ProgressBar progressbar2 = findViewById(R.id.progressBar);
                if (isChecked) {
                    button2.setBackgroundColor(Color.TRANSPARENT);
                    button2.setTextColor(Color.TRANSPARENT);
                    button.setBackgroundResource(R.mipmap.trang4);
                    button.setTextColor(Color.BLACK);
                    simpleChronometer.setBase(SystemClock.elapsedRealtime());
                    simpleChronometer.start();
                    simpleChronometer2.stop();
                    simpleChronometer.setVisibility(View.VISIBLE);
                    simpleChronometer2.setVisibility(View.INVISIBLE);
                    progressbar.setVisibility(View.VISIBLE);
                    progressbar.bringToFront();
                    progressbar2.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "We live on a placid island of ignorance in the midst of black seas of infinity, and it was not meant that we should voyage far.", Toast.LENGTH_SHORT).show();
                    button.setBackgroundResource(R.mipmap.trang3);
                    button.setTextColor(Color.BLACK);
                    simpleChronometer.stop();
                    simpleChronometer.setVisibility(View.VISIBLE);
                    progressbar.setVisibility(View.INVISIBLE);

                    Toast.makeText(MainActivity.this, "bruh", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sicko Mode: Activated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
            
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }
        });
    }
}