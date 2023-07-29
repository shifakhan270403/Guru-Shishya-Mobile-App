package com.example.gurushishyamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer time ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,loginActivity.class);
                startActivity(i);
                finish();
            }
        },2000);
    }
}