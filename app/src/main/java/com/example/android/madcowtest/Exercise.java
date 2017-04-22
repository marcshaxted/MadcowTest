package com.example.android.madcowtest;


import java.util.ArrayList;

public class Exercise {

    private String mExerciseName;
    private ArrayList<ExerciseSet> mSets;

    public Exercise(String name) {
        mExerciseName = name;
        mSets = new ArrayList<>();
    }

    public ArrayList<ExerciseSet> getSets() {
        return mSets;
    }

    public String getName() {
        return mExerciseName;
    }
}
