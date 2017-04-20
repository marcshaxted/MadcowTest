package com.example.android.madcowtest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class WorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String dateString = sdf.format(date);

        TextView dateTextView = (TextView) findViewById(R.id.date_text_view);

        dateTextView.setText(dateString);
    }

    public void buttonClicked(View view) {

        Button button = (Button) view;

        if (button.getText() != "Done!") {

            button.setText("Done!");
            button.setClickable(false);
            Chronometer timer = (Chronometer) findViewById(R.id.chronometer);
            timer.setVisibility(View.VISIBLE);
            timer.setBase(SystemClock.elapsedRealtime());
            timer.start();
        }
    }
}
