package com.example.android.madcowtest;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalibrationActivity extends AppCompatActivity {

    private final double ROUNDING = 1.0;

    private LayoutInflater mInflater;

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {

            //This needs to be more specific
            TextView result = (TextView) findViewById(R.id.result);
            String reps = ((EditText) findViewById(R.id.reps)).getText().toString();
            String weight = ((EditText) findViewById(R.id.weight)).getText().toString();
            int repsValue = 0;
            double weightValue = 0;
            try {
                repsValue = Integer.parseInt(reps);
                weightValue = Double.parseDouble(weight);
            } catch (Exception e) {
            }

            double res = calcOneRepMax(repsValue, weightValue);
            res = (int) Math.round(res / 2.5);
            res = res * 2.5;

            if (res != 0) {
                result.setText(String.valueOf(res));
            }
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibration);

        Toolbar tb = (Toolbar) findViewById(R.id.calibration_toolbar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true); // show or hide the default home button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
        ab.setDisplayShowTitleEnabled(false); // disable the default title e

        init();
    }


    private void init() {

        mInflater = LayoutInflater.from(this);
        ((LinearLayout) this.findViewById(R.id.calibrations)).removeAllViews();

        String[] exercises = new String[]{"squat 1rm", "bench 1rm", "deadlift 1rm", "press 1rm"};

        //Change this to add to inflate in parent
        for (String s : exercises) {

            LinearLayout calib = (LinearLayout) mInflater.inflate(R.layout.calibration, null);
            ((TextView) calib.findViewById(R.id.name)).setText(s);
            ((LinearLayout) this.findViewById(R.id.calibrations)).addView(calib);
            setupEventListeners(calib);
        }
    }

    private void setupEventListeners(LinearLayout calib) {

        EditText repsInput = (EditText) calib.findViewById(R.id.reps);
        repsInput.addTextChangedListener(new GenericTextWatcher(calib));

        EditText weightInput = (EditText) calib.findViewById(R.id.weight);
        weightInput.addTextChangedListener(new GenericTextWatcher(calib));
    }

    private double calcOneRepMax(int reps, double weight) {

        return weight / (1.0278 - (0.0287 * (double) reps));
    }

    private class GenericTextWatcher implements TextWatcher {

        private View mView;

        private GenericTextWatcher(View view) {
            mView = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable s) {

            //This needs to be more specific
            TextView result = (TextView) mView.findViewById(R.id.result);
            String reps = ((EditText) mView.findViewById(R.id.reps)).getText().toString();
            String weight = ((EditText) mView.findViewById(R.id.weight)).getText().toString();

            int repsValue = 0;
            double weightValue = 0;
            try {
                repsValue = Integer.parseInt(reps);
                weightValue = Double.parseDouble(weight);
            } catch (Exception e) {
            }

            double res = calcOneRepMax(repsValue, weightValue);
//            res = (int) Math.round(res / ROUNDING);
//            res = res * ROUNDING;

            if (res != 0) {
                result.setText(String.valueOf((int) res));
            }
        }
    }
}
