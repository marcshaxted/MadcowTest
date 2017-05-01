package com.example.android.madcowtest;

import java.util.Date;

public class WorkoutA extends Workout {

    private static final String WORKOUT_NAME = "Workout A";

    public WorkoutA(Date date, double squatWeight, double benchWeight, double rowWeight) {
        super(WORKOUT_NAME, date);
        init(squatWeight, benchWeight, rowWeight);
    }

    private void init(double squatWeight, double benchWeight, double rowWeight) {

        setupSquats(squatWeight, 0.125);
        setupBench(benchWeight, 0.125);
        setupRow(rowWeight, 0.125);
    }

    private void setupSquats(double weight, double interval) {

        Exercise squats = setupExercise("squat", weight, interval);
        getExercises().add(squats);
    }

    private void setupBench(double weight, double interval) {

        Exercise bench = setupExercise("bench", weight, interval);
        getExercises().add(bench);
    }

    private void setupRow(double weight, double interval) {

        Exercise row = setupExercise("row", weight, interval);
        getExercises().add(row);
    }

    private Exercise setupExercise(String name, double weight, double interval) {

        Exercise ex = new Exercise(name);
        ex.addSet(new ExerciseSet(5, calcWeight(weight, interval * 4)));
        ex.addSet(new ExerciseSet(5, calcWeight(weight, interval * 3)));
        ex.addSet(new ExerciseSet(5, calcWeight(weight, interval * 2)));
        ex.addSet(new ExerciseSet(5, calcWeight(weight, interval)));
        ex.addSet(new ExerciseSet(5, weight));
        return ex;
    }
}
