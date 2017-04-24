package com.example.android.madcowtest;


import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Exercise extends LinearLayout {

    private String mExerciseName;
    private ArrayList<ExerciseSet> mSets;
    private LinearLayout mSetsLayout;

    public Exercise(Context context) {
        super(context);
    }

    public Exercise(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Exercise(Context context, String name) {
        super(context);
        init(context, name);
    }

    public void addSet(ExerciseSet set) {
        mSets.add(set);
        mSetsLayout.addView(set);
    }

    private void init(Context context, String name) {
        mExerciseName = name;
        mSets = new ArrayList<>();

        this.setOrientation(VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.weight = 1;
        this.setLayoutParams(lp);

        TextView tv = new TextView(context);
        tv.setText(name);
        this.addView(tv);

        mSetsLayout = new LinearLayout(context);
        mSetsLayout.setOrientation(HORIZONTAL);
        mSetsLayout.setLayoutParams(lp);
        this.addView(mSetsLayout);
    }
}
