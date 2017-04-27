package com.example.android.madcowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class CalibrationActivity extends AppCompatActivity {

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {

            TextView result = (TextView) findViewById(R.id.squats_result);
            String reps = ((EditText) findViewById(R.id.squats_reps)).getText().toString();
            String weight = ((EditText) findViewById(R.id.squats_weight)).getText().toString();
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
        setupEventListeners();
    }

    private void setupEventListeners() {

        EditText repsInput = (EditText) findViewById(R.id.squats_reps);
        repsInput.addTextChangedListener(mTextWatcher);

        EditText weightInput = (EditText) findViewById(R.id.squats_weight);
        weightInput.addTextChangedListener(mTextWatcher);

    }

    private double calcOneRepMax(int reps, double weight) {
        double retVal = weight;
        double foo = (double) reps / 30;
        foo = foo + 1;
        retVal = retVal * foo;


        return retVal;
    }
}
