package com.example.android.madcowtest;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ExerciseSet extends AppCompatButton implements View.OnClickListener {

    private int mReps;
    private double mWeight;
    private Status mStatus;

    public ExerciseSet(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public ExerciseSet(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    public ExerciseSet(Context context, int reps, double weight) {
        super(context);
        init(reps, weight);
    }

    private void init(int reps, double weight) {
        Log.v(ExerciseSet.class.getSimpleName(), "Initialisation");

        mReps = reps;
        mWeight = weight;
        mStatus = Status.PENDING;

        setOnClickListener(this);
        this.setText(String.valueOf(mReps));
    }

    private Status toggleStatus() {
        if (mStatus == Status.FAIL) {
            mStatus = Status.PENDING;
        } else if (mStatus == Status.PENDING) {
            mStatus = Status.COMPLETE;
        } else {
            mStatus = Status.FAIL;
        }
        return mStatus;
    }

    @Override
    public void onClick(View v) {
        Log.v(ExerciseSet.class.getSimpleName(), "Clicked");

        ExerciseSet es = (ExerciseSet) v;
        es.toggleStatus();

        String buttonTitle = null;

        switch (mStatus) {

            case COMPLETE:
                buttonTitle = "Done";
                break;

            case FAIL:
                buttonTitle = "Fail";
                break;

            case PENDING:
                buttonTitle = String.valueOf(mReps);
                break;
        }
        es.setText(buttonTitle);
    }

    public enum Status {
        PENDING,
        COMPLETE,
        FAIL
    }

}
