package com.example.kingcrimson;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ToggleButton button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.button1);

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ToggleButton button = findViewById(R.id.button1);
                ToggleButton button2 = findViewById(R.id.button2);
                Chronometer simpleChronometer = findViewById(R.id.simpleChronometer);
                Chronometer simpleChronometer2 = findViewById(R.id.simpleChronometer2);
                ProgressBar progressbar = findViewById(R.id.progressBar);
                if (isChecked) {
                    button2.setBackgroundColor(Color.TRANSPARENT);
                    button2.setTextColor(Color.TRANSPARENT);
                    button.setBackgroundResource(R.mipmap.trang2);
                    button.setTextColor(Color.BLACK);
                    simpleChronometer.start();
                    simpleChronometer2.stop();
                    simpleChronometer2.setVisibility(View.VISIBLE);
                    simpleChronometer2.setVisibility(View.INVISIBLE);
                    progressbar.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "We live on a placid island of ignorance in the midst of black seas of infinity, and it was not meant that we should voyage far.", Toast.LENGTH_SHORT).show();
                    button.setBackgroundResource(R.mipmap.trang1);
                    button.setTextColor(Color.BLACK);
                    progressbar.setVisibility(View.INVISIBLE);
                    simpleChronometer.stop();
                    Toast.makeText(MainActivity.this, "bruh", Toast.LENGTH_SHORT).show();
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
                if (isChecked) {
                    button2.setBackgroundColor(Color.TRANSPARENT);
                    button2.setTextColor(Color.TRANSPARENT);
                    button.setBackgroundResource(R.mipmap.trang4);
                    button.setTextColor(Color.BLACK);
                    simpleChronometer.start();
                    simpleChronometer2.stop();
                    simpleChronometer.setVisibility(View.VISIBLE);
                    simpleChronometer2.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "We live on a placid island of ignorance in the midst of black seas of infinity, and it was not meant that we should voyage far.", Toast.LENGTH_SHORT).show();
                    button.setBackgroundResource(R.mipmap.trang3);
                    button.setTextColor(Color.BLACK);
                    simpleChronometer.stop();

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