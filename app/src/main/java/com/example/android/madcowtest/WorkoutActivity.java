package com.example.android.madcowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
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

        Exercise ex1 = new Exercise("Squats");
        ex1.getSets().add(new ExerciseSet(this, 5, 65));
        ex1.getSets().add(new ExerciseSet(this, 5, 75));
        ex1.getSets().add(new ExerciseSet(this, 5, 85));
        ex1.getSets().add(new ExerciseSet(this, 5, 95));
        ex1.getSets().add(new ExerciseSet(this, 5, 105));

        mWorkout.getExercises().add(ex1);

        Exercise ex2 = new Exercise("Bench press");
        ex2.getSets().add(new ExerciseSet(this, 5, 35));
        ex2.getSets().add(new ExerciseSet(this, 5, 45));
        ex2.getSets().add(new ExerciseSet(this, 5, 55));
        ex2.getSets().add(new ExerciseSet(this, 5, 65));
        ex2.getSets().add(new ExerciseSet(this, 5, 175));

        mWorkout.getExercises().add(ex2);

        //Set the workout name & date
        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_title)).setText(mWorkout.getName());
        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_date)).setText(mWorkout.getDateString());

        //Create a layout inflater
        LayoutInflater inflater = LayoutInflater.from(this);

        //Get the exercises view and remove all children
        LinearLayout exercises = (LinearLayout) this.findViewById(R.id.exercises);
        exercises.removeAllViews();

        for (Exercise exercise : mWorkout.getExercises()) {

            //LinearLayout is a subclass of ViewGroup, which has a method called addView. The addView method should be what you are after.

            //Create new exercise layout
            View exerciseLayout = inflater.inflate(R.layout.exercise, null);

            //Add excercise name
            ((TextView) exerciseLayout.findViewById(R.id.exercise_name)).setText(exercise.getName());

            //Get exercise sets and remove all children
            LinearLayout exerciseSets = (LinearLayout) exerciseLayout.findViewById(R.id.exercise_sets);
            exerciseSets.removeAllViews();

            for (ExerciseSet set : exercise.getSets()) {
                //Add set to exercise
                exerciseSets.addView(set);
            }

            //Add exercise
            exercises.addView(exerciseLayout);

        }



    }
}
