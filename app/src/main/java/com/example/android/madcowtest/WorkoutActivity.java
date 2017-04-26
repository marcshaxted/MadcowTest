package com.example.android.madcowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class WorkoutActivity extends AppCompatActivity {

    private LayoutInflater mInflater;

    private Workout mWorkout;


    private View.OnClickListener mSetButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ExerciseSet set = (ExerciseSet) v.getTag();

            set.toggleStatus();

            ((Button) v).setText(set.getStatus());

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        createWorkout();

        setupHeader(mWorkout.getName(), mWorkout.getDateString());

        mInflater = LayoutInflater.from(this);

        for (Exercise exercise : mWorkout.getExercises()) {

            //Create new exercise layout
            View exerciseLayout = createExerciseLayout(exercise.getName());

            for (ExerciseSet set : exercise.getSets()) {

                LinearLayout exerciseSets = (LinearLayout) exerciseLayout.findViewById(R.id.exercise_sets);
                exerciseSets.addView(createExerciseSet(set));
            }

            ((LinearLayout) this.findViewById(R.id.exercises)).addView(exerciseLayout);
        }
    }

    private void setupHeader(String workoutName, String workoutDate) {

        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_title)).setText(workoutName);
        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_date)).setText(workoutDate);
    }

    private void createWorkout() {

        //Create a test workout
        mWorkout = new Workout("Test workout", new Date());

        Exercise ex1 = new Exercise("Squats");
        ex1.getSets().add(new ExerciseSet(5, 65));
        ex1.getSets().add(new ExerciseSet(5, 75));
        ex1.getSets().add(new ExerciseSet(5, 85));
        ex1.getSets().add(new ExerciseSet(5, 95));
        ex1.getSets().add(new ExerciseSet(5, 105));

        mWorkout.getExercises().add(ex1);

        Exercise ex2 = new Exercise("Bench press");
        ex2.getSets().add(new ExerciseSet(5, 35));
        ex2.getSets().add(new ExerciseSet(5, 45));
        ex2.getSets().add(new ExerciseSet(5, 55));
        ex2.getSets().add(new ExerciseSet(5, 65));
        ex2.getSets().add(new ExerciseSet(5, 175));

        mWorkout.getExercises().add(ex2);
    }

    private View createExerciseLayout(String name) {

        //Inflate a new exercise layout
        View exerciseLayout = mInflater.inflate(R.layout.exercise, null);

        //Add exercise name
        ((TextView) exerciseLayout.findViewById(R.id.exercise_name)).setText(name);

        //Get exercise sets and remove all children
        LinearLayout exerciseSets = (LinearLayout) exerciseLayout.findViewById(R.id.exercise_sets);
        exerciseSets.removeAllViews();

        return exerciseLayout;
    }

    private View createExerciseSet(ExerciseSet set) {

        View exerciseSet = mInflater.inflate(R.layout.exercise_set, null);

        //Create a new set button
        Button setButton = ((Button) exerciseSet.findViewById(R.id.set_button));

        //Set the number of reps on the button
        setButton.setText(String.valueOf(set.getReps()));

        //Set button tag
        setButton.setTag(0, set);

        //Set button click listener
        setButton.setOnClickListener(mSetButtonOnClickListener);

        //Set the weight on the text view
        ((TextView) exerciseSet.findViewById(R.id.set_textview)).setText(String.valueOf(set.getWeight()));

        return exerciseSet;
    }

}
