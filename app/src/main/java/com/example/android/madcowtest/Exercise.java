package com.example.android.madcowtest;


import java.util.ArrayList;

public class Exercise {

    private String mExerciseName;
    private ArrayList<ExerciseSet> mSets;

    public Exercise(String name) {
        mExerciseName = name;
        mSets = new ArrayList<>();

    }

    public String getName() {
        return mExerciseName;
    }

    public ArrayList<ExerciseSet> getSets() {
        return mSets;
    }

    public void addSet(ExerciseSet set) {
        mSets.add(set);
    }

}
