package com.example.android.madcowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class WorkoutActivity extends AppCompatActivity {

    private Workout mWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        //Create a test workout
        mWorkout = new Workout("Test workout", new Date());

        Exercise ex1 = new Exercise(this, "Squats");
        ex1.addSet(new ExerciseSet(this, 5, 65));
        ex1.addSet(new ExerciseSet(this, 5, 75));
        ex1.addSet(new ExerciseSet(this, 5, 85));
        ex1.addSet(new ExerciseSet(this, 5, 95));
        ex1.addSet(new ExerciseSet(this, 5, 105));

        Exercise ex2 = new Exercise(this, "Bench press");
        ex2.addSet(new ExerciseSet(this, 5, 35));
        ex2.addSet(new ExerciseSet(this, 5, 45));
        ex2.addSet(new ExerciseSet(this, 5, 55));
        ex2.addSet(new ExerciseSet(this, 5, 65));
        ex2.addSet(new ExerciseSet(this, 5, 75));

        //Set the workout name & date
        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_title)).setText(mWorkout.getName());
        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_date)).setText(mWorkout.getDateString());

        LayoutInflater inflater = LayoutInflater.from(this);

        //Get the exercises view and remove all children
        LinearLayout exercises = (LinearLayout) this.findViewById(R.id.exercises);
        exercises.removeAllViews();
        exercises.addView(ex1);
        exercises.addView(ex2);

    }
}
