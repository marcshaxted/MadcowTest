package com.example.android.madcowtest;

import java.util.Date;

public class WorkoutC extends Workout {


    private static final String WORKOUT_NAME = "Workout A";

    public WorkoutC(Date date, double squatWeight, double benchWeight, double rowWeight) {
        super(WORKOUT_NAME, date);
        //init(squatWeight, benchWeight, rowWeight);

    }
}
