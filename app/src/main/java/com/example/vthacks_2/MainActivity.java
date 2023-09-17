package com.example.vthacks_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etCreditScore = (EditText) findViewById(R.id.creditscore);
        EditText etAvgExpidenture = (EditText) findViewById(R.id.averageexpidenture);
        EditText etMonthlyincome = (EditText) findViewById(R.id.monthlyincome);

        // when the clear button is clicked
        Button btnClear = (Button) findViewById(R.id.buttonClear);
        AdapterView.OnClickListener ocl;
        ocl = new AdapterView.OnClickListener() {
            public void onClick(View v) {

                etCreditScore.getText().clear();
                etAvgExpidenture.getText().clear();
                etMonthlyincome.getText().clear();

            }
        };
        btnClear.setOnClickListener(ocl);
        btnClear.setEnabled(false);


        // Toggles the button enabling - by knowing when there is information to convert
        TextWatcher tw;
        tw = new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etCreditScore.getText().length() == 0 && etAvgExpidenture.getText().length() == 0 && etMonthlyincome.getText().length() == 0) {
                    btnClear.setEnabled(false);
                    btnClear.setEnabled(false);
                } else {
                    btnClear.setEnabled(true);
                }
            }
        };
        etCreditScore.addTextChangedListener(tw);
        etAvgExpidenture.addTextChangedListener(tw);
        etMonthlyincome.addTextChangedListener(tw);
    }
// HEllO

}


