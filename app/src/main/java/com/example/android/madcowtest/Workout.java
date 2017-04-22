package com.example.android.madcowtest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Workout {

    private String mWorkoutName;
    private Date mDate;
    private String mDateString;
    private ArrayList<Exercise> mExercises;

    public Workout(String name, Date date) {
        mWorkoutName = name;
        mDate = date;
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        mDateString = dateFormat.format(date);
        mExercises = new ArrayList<>();
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
}
