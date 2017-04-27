package com.example.android.madcowtest;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ExerciseSetTextView extends AppCompatTextView {

    private double mWeight;

    public ExerciseSetTextView(Context context) {
        super(context);
    }

    public ExerciseSetTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExerciseSetTextView(Context context, double weight) {
        super(context);
        init(weight);
    }

    private void init(double weight) {
        mWeight = weight;
        this.setText(String.valueOf(mWeight));

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;

        this.setLayoutParams(lp);

    }
}
