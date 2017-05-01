package com.example.android.madcowtest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

abstract class Workout {

    double mMinPlateSize = 1.25;

    private String mWorkoutName;
    private Date mDate;
    private String mDateString;
    private ArrayList<Exercise> mExercises;
    private Exercise mAccessoryExercise;

    public Workout(String name, Date date) {
        mWorkoutName = name;
        mDate = date;
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        mDateString = dateFormat.format(date);
        mExercises = new ArrayList<>();
    }

    public void setAccessoryExercise(Exercise exercise) {
        mAccessoryExercise = exercise;
    }

    public Exercise getAccessoryExcercise() {
        return mAccessoryExercise;
    }

    public ArrayList<Exercise> getExercises() {
        return mExercises;
    }

    public String getName() {
        return mWorkoutName;
    }

    public String getDateString() {
        return mDateString;
    }

    public Date getDate() {
        return mDate;
    }

    protected double calcWeight(double finalWeight, double interval) {
        int retVal = (int) Math.round(finalWeight * (1 - interval) / (2 * mMinPlateSize));
        return retVal * 2 * mMinPlateSize;
    }

    public static enum WorkoutType {
        WORKOUT_A,
        WORKOUT_B,
        WORKOUT_C
    }
}
