package com.example.android.madcowtest;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.calibrate_text_view).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                Intent i = new Intent(getApplicationContext(), CalibrationActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.next_workout_text_view).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                Intent i = new Intent(getApplicationContext(), WorkoutActivity.class);
                startActivity(i);
            }
        });

    }
}
