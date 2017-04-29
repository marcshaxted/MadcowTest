package com.example.android.madcowtest;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
            ((Button) v).setText(set.getStatusString());
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        init();
    }

    private void init() {
//        this.getActionBar().setDisplayHomeAsUpEnabled(true);
        mInflater = LayoutInflater.from(this);

        //Create a test workout.  At some point this will be loaded from store and the weights and reps calculated
        createWorkout();

        setupWorkoutLayout();
    }

    private void setupHeader(String workoutName, String workoutDate) {

        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_title)).setText(workoutName);
        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_date)).setText(workoutDate);
    }

    private void createWorkout() {

        //Create a test workout
        mWorkout = new Workout("Test workout", new Date());

        Exercise ex1 = new Exercise("Squat");
        ex1.addSet(new ExerciseSet(5, 65));
        ex1.addSet(new ExerciseSet(5, 75));
        ex1.addSet(new ExerciseSet(5, 85));
        ex1.addSet(new ExerciseSet(5, 95));
        ex1.addSet(new ExerciseSet(5, 105));

        mWorkout.getExercises().add(ex1);

        Exercise ex2 = new Exercise("Bench press");
        ex2.addSet(new ExerciseSet(5, 35));
        ex2.addSet(new ExerciseSet(5, 45));
        ex2.addSet(new ExerciseSet(5, 55));
        ex2.addSet(new ExerciseSet(5, 65));
        ex2.addSet(new ExerciseSet(5, 175));

        mWorkout.getExercises().add(ex2);

        Exercise ex3 = new Exercise("Row");
        ex3.addSet(new ExerciseSet(5, 35));
        ex3.addSet(new ExerciseSet(5, 45));
        ex3.addSet(new ExerciseSet(5, 55));
        ex3.addSet(new ExerciseSet(5, 65));
        ex3.addSet(new ExerciseSet(5, 175));

        mWorkout.getExercises().add(ex3);
    }

    private void setupWorkoutLayout() {
        setupHeader(mWorkout.getName(), mWorkout.getDateString());
        ((LinearLayout) this.findViewById(R.id.exercises)).removeAllViews();

        this.findViewById(R.id.finish_workout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(this.getClass().getSimpleName(), "Writing out the status of mWorkout");
            }
        });

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

    private LinearLayout createExerciseSet(ExerciseSet set) {

        LinearLayout exerciseSet = (LinearLayout) mInflater.inflate(R.layout.exercise_set, null);
        LinearLayout.LayoutParams exerciseLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        exerciseLayoutParams.weight = 1;
        exerciseSet.setLayoutParams(exerciseLayoutParams);

        //Create a new set button
        Button setButton = ((Button) exerciseSet.findViewById(R.id.set_button));

        //Set the number of reps on the button
        setButton.setText(String.valueOf(set.getReps()));

        //Set button tag
        setButton.setTag(set);

        //Set button click listener
        setButton.setOnClickListener(mSetButtonOnClickListener);

        //Set the weight on the text view
        ((TextView) exerciseSet.findViewById(R.id.set_textview)).setText(String.valueOf(set.getWeight()));

        return exerciseSet;
    }

}
