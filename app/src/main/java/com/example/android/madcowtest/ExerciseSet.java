package com.example.android.madcowtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ExerciseSet extends LinearLayout {

    private ExerciseSetButton mButton;
    private ExerciseSetTextView mLabel;


    public ExerciseSet(Context context) {
        super(context);
    }

    public ExerciseSet(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExerciseSet(Context context, int reps, double weight) {
        super(context);

        init(context, reps, weight);
    }

    private void init(Context context, int reps, double weight) {
        Log.v(ExerciseSet.class.getSimpleName(), "Initialisation");

        this.setOrientation(VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.weight = 1;

        this.setLayoutParams(lp);

        mButton = new ExerciseSetButton(context, reps);
        this.addView(mButton);

        mLabel = new ExerciseSetTextView(context, weight);
        this.addView(mLabel);

    }
}
