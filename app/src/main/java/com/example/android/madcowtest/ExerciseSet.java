package com.example.android.madcowtest;

public class ExerciseSet {

    private int mReps;
    private double mWeight;
    private Status mStatus;

    public ExerciseSet(int reps, double weight) {
        mReps = reps;
        mWeight = weight;
        mStatus = Status.PENDING;
    }

    public int getReps() {
        return mReps;
    }

    public double getWeight() {
        return mWeight;
    }

    public Status getStatusString() {
        return mStatus;
    }

    public Status toggleStatus() {
        if (mStatus == Status.FAIL) {
            mStatus = Status.PENDING;
        } else if (mStatus == Status.PENDING) {
            mStatus = Status.COMPLETE;
        } else {
            mStatus = Status.FAIL;
        }
        return mStatus;
    }

    public enum Status {
        PENDING,
        COMPLETE,
        FAIL
    }

}
