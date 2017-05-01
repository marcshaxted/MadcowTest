package com.example.android.madcowtest;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
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

//            if (set.getStatus() != ExerciseSet.Status.PENDING) {
//                v.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDark));
//            } else {
//                v.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.accent));
//            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.workout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.include_optional_exercise:
                Log.v(this.getClass().getSimpleName(), String.valueOf(item.getTitle()));

                if (item.getTitle() == "Include accessory exercise") {
                    item.setTitle("Exclude accessory exercise");
                } else {
                    item.setTitle("Include accessory exercise");
                }

                return true;

            case R.id.workout_settings:
                Log.v(this.getClass().getSimpleName(), "Change workout settings");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Toolbar tb = (Toolbar) findViewById(R.id.workout_toolbar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true); // show or hide the default home button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
        ab.setDisplayShowTitleEnabled(false); // disable the default title e

        init();
    }

    private void init() {
        mInflater = LayoutInflater.from(this);

        //Create a test workout.  At some point this will be loaded from store and the weights and reps calculated
        createWorkout(Workout.WorkoutType.WORKOUT_A, 120.0, 85.0, 90.0);

        //Set up the layout
        setupWorkoutLayout();
    }

    private void setupHeader(String workoutName, String workoutDate) {

        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_title)).setText(workoutName);
        ((TextView) this.findViewById(R.id.header).findViewById(R.id.header_date)).setText(workoutDate);
    }

    private void createWorkout(Workout.WorkoutType workoutType, double exerciseOneWeight, double exerciseTwoWeight, double exerciseThreeWeight) {

        switch (workoutType) {
            case WORKOUT_A:
                mWorkout = new WorkoutA(new Date(), exerciseOneWeight, exerciseTwoWeight, exerciseThreeWeight);
                break;

            case WORKOUT_B:
                mWorkout = new WorkoutB(new Date(), exerciseOneWeight, exerciseTwoWeight, exerciseThreeWeight);
                break;

            case WORKOUT_C:
                mWorkout = new WorkoutC(new Date(), exerciseOneWeight, exerciseTwoWeight, exerciseThreeWeight);
                break;
        }
    }

    private void setupWorkoutLayout() {
        setupHeader(mWorkout.getName(), mWorkout.getDateString());

        this.findViewById(R.id.finish_workout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(this.getClass().getSimpleName(), "Writing out the status of mWorkout");
            }
        });

        //Get the exercises LinearLayout
        ViewGroup exercisesLayout = (ViewGroup) this.findViewById(R.id.exercises);

        //Add the exercises to the exercises LinearLayout
        addExercises(mWorkout.getExercises(), exercisesLayout);

    }

    private void addExercises(ArrayList<Exercise> exercises, ViewGroup parent) {

        //Remove any existing exercises layouts
        parent.removeAllViews();

        int i = 0;
        for (Exercise exercise : exercises) {

            //Add a new exercise layout to the parent
            mInflater.inflate(R.layout.exercise, parent);

            //Get the exercise layout back
            ViewGroup exerciseLayout = (LinearLayout) parent.getChildAt(i);

            //Add exercise name
            ((TextView) exerciseLayout.findViewById(R.id.exercise_name)).setText(exercise.getName());

            //Get the exercise sets layout
            ViewGroup exerciseSetsLayout = (ViewGroup) exerciseLayout.findViewById(R.id.exercise_sets);

            //Add the sets to the exercise sets layout
            addExerciseSets(exercise.getSets(), exerciseSetsLayout);

            i++;
        }
    }

    private void addExerciseSets(ArrayList<ExerciseSet> sets, ViewGroup parent) {

        //Remove all exercise set layouts from the exercise sets layout
        parent.removeAllViews();

        int i = 0;
        for (ExerciseSet set : sets) {

            //Add new set to parent
            mInflater.inflate(R.layout.exercise_set, parent);

            //Get the set back
            View exerciseSetLayout = parent.getChildAt(i);

            //Get the set button
            Button setButton = ((Button) exerciseSetLayout.findViewById(R.id.set_button));

            //Set the number of reps on the button
            setButton.setText(String.valueOf(set.getReps()));

            //Set button tag
            setButton.setTag(set);

            //Set button click listener
            setButton.setOnClickListener(mSetButtonOnClickListener);

            //Set the weight on the text view
            ((TextView) exerciseSetLayout.findViewById(R.id.set_textview)).setText(String.valueOf(set.getWeight()));

            i++;
        }
    }
}
