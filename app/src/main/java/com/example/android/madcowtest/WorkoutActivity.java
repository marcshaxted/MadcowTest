package com.example.android.madcowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        TextView headerTextView = (TextView) this.findViewById(R.id.header).findViewById(R.id.header_title_text_view);
        headerTextView.setText("Workout A");

        TextView dateTextView = (TextView) this.findViewById(R.id.header).findViewById(R.id.header_date_text_view);
        dateTextView.setText("25th December 2017");

        LinearLayout exercises = (LinearLayout) this.findViewById(R.id.exercises);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View exerciseLayout = inflater.inflate(R.layout.exercise, (ViewGroup) findViewById(R.id.exercise));

        for (int i = 0; i < 2; i++) {
            exercises.addView(exerciseLayout);
        }
    }
}
