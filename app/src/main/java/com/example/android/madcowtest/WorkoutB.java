package com.example.android.madcowtest;

import java.util.Date;

public class WorkoutB extends Workout {

    private static final String WORKOUT_NAME = "Workout B";

    public WorkoutB(Date date, double squatWeight, double benchWeight, double rowWeight) {
        super(WORKOUT_NAME, date);
        init(squatWeight, benchWeight, rowWeight);
    }

    private void init(double squatWeight, double pressWeight, double deadliftWeight) {

        setupSquats(squatWeight, 0.125);
        setupPress(pressWeight, 0.125);
        setupDeadlift(deadliftWeight, 0.125);
    }

    private void setupSquats(double weight, double interval) {

        Exercise squats = setupExercise("squat", weight, interval);
        getExercises().add(squats);
    }

    private void setupPress(double weight, double interval) {
        Exercise bench = setupExercise("press", weight, interval);
        getExercises().add(bench);
    }

    private void setupDeadlift(double weight, double interval) {
        Exercise row = setupExercise("deadlift", weight, interval);
        getExercises().add(row);
    }

    private Exercise setupExercise(String name, double weight, double interval) {

        Exercise ex = new Exercise(name);
        ex.addSet(new ExerciseSet(5, calcWeight(weight, interval * 4)));
        ex.addSet(new ExerciseSet(5, calcWeight(weight, interval * 3)));
        ex.addSet(new ExerciseSet(5, calcWeight(weight, interval * 2)));
        ex.addSet(new ExerciseSet(5, calcWeight(weight, interval * 2)));
        return ex;
    }


}
