package com.example.android.madcowtest;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class ExerciseSetButton extends AppCompatButton implements View.OnClickListener {

    private int mReps;
    private Status mStatus;

    public ExerciseSetButton(Context context) {
        super(context);
    }

    public ExerciseSetButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExerciseSetButton(Context context, int reps) {
        super(context);
        init(reps);
    }

    private void init(int reps) {
        Log.v(ExerciseSetButton.class.getSimpleName(), "Initialisation");

        mReps = reps;
        mStatus = Status.PENDING;

        setOnClickListener(this);
        this.setText(String.valueOf(mReps));
        this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    private Status toggleStatus() {
        if (mStatus == Status.FAIL) {
            mStatus = Status.PENDING;
        } else if (mStatus == Status.PENDING) {
            mStatus = Status.DONE;
        } else {
            mStatus = Status.FAIL;
        }
        return mStatus;
    }

    @Override
    public void onClick(View v) {
        Log.v(ExerciseSetButton.class.getSimpleName(), "Clicked");

        ExerciseSetButton es = (ExerciseSetButton) v;
        es.toggleStatus();

        String buttonTitle = null;

        switch (mStatus) {

            case DONE:
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
        DONE,
        FAIL
    }

}
