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

    public String getStatusString() {
        if (mStatus == Status.FAIL) {
            return "FAIL";
        } else if (mStatus == Status.PENDING) {
            return String.valueOf(mReps);
        } else {
            return "DONE";
        }
    }

    public void toggleStatus() {
        if (mStatus == Status.FAIL) {
            mStatus = Status.PENDING;
        } else if (mStatus == Status.PENDING) {
            mStatus = Status.DONE;
        } else {
            mStatus = Status.FAIL;
        }
    }

    public Status getStatus() {
        return mStatus;
    }

    public enum Status {
        PENDING,
        DONE,
        FAIL
    }

}
