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

    private Workout mWorkout;

    private View.OnClickListener mSetButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        createWorkout();

        setupHeader(mWorkout.getName(), mWorkout.getDateString());

        LayoutInflater inflater = LayoutInflater.from(this);

        for (Exercise exercise : mWorkout.getExercises()) {

            //Create new exercise layout
            View exerciseLayout = createExerciseLayout(exercise.getName());

            //Create exercise sets
            LinearLayout exerciseSets = createExerciseSetsLayout();

            for (ExerciseSet set : exercise.getSets()) {
                //Get a new exercise set layout
                View exerciseSet = inflater.inflate(R.layout.exercise_set, null);

                //Set the number of reps on the button
                Button setButton = ((Button) exerciseSet.findViewById(R.id.set_button));
                //setButton.setId();
                setButton.setText(String.valueOf(set.getReps()));
                setButton.setOnClickListener(mSetButtonOnClickListener);

                //Set the weight on the text view
                ((TextView) exerciseSet.findViewById(R.id.set_textview)).setText(String.valueOf(set.getWeight()));

                //Add the set to the exercise
                exerciseSets.addView(exerciseSet);
            }

            //Add exercise
            exercises.addView(exerciseLayout);

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
        View exerciseLayout = this.getLayoutInflater().inflate(R.layout.exercise, null);

        //Add exercise name
        ((TextView) exerciseLayout.findViewById(R.id.exercise_name)).setText(name);

        //Get exercise sets and remove all children
        LinearLayout exerciseSets = (LinearLayout) exerciseLayout.findViewById(R.id.exercise_sets);
        exerciseSets.removeAllViews();

        return exerciseLayout;
    }

    private LinearLayout createExerciseSetsLayout() {
        LinearLayout exerciseSets = (LinearLayout) this.getLayoutInflater().inflate(R.layout.exercise_sets, null);
        exerciseSets.removeAllViews();
        return exerciseSets;
    }
}
