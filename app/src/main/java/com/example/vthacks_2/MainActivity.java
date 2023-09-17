package com.example.vthacks_2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText creditScore;
    private EditText averageExpenditure;
    private EditText monthlyIncome;

    private EditText credscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creditScore = findViewById(R.id.creditscore);
        averageExpenditure = findViewById(R.id.averageexpenditure);
        monthlyIncome = findViewById(R.id.monthlyincome);

        // when the clear button is clicked
        Button btnClear = (Button) findViewById(R.id.buttonClear);
        AdapterView.OnClickListener ocl;
        ocl = new AdapterView.OnClickListener() {
            public void onClick(View v) {

                creditScore.getText().clear();
                averageExpenditure.getText().clear();
                monthlyIncome.getText().clear();

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
                if (creditScore.getText().length() == 0 && averageExpenditure.getText().length() == 0 && monthlyIncome.getText().length() == 0) {
                    btnClear.setEnabled(false);
                    btnClear.setEnabled(false);
                } else {
                    btnClear.setEnabled(true);
                }
            }
        };
        creditScore.addTextChangedListener(tw);
        averageExpenditure.addTextChangedListener(tw);
        monthlyIncome.addTextChangedListener(tw);

    }

    public void clickNext(View v) {
        creditScore = findViewById(R.id.creditscore);
        averageExpenditure = findViewById(R.id.averageexpenditure);
        monthlyIncome = findViewById(R.id.monthlyincome);

        String creditScoreStr = creditScore.getText().toString();
        String averageExpenditureStr = averageExpenditure.getText().toString();
        String monthlyIncomeStr = monthlyIncome.getText().toString();

        int creditScoreVal = Integer.parseInt(creditScoreStr);
        double averageExpenditureVal = Double.parseDouble(averageExpenditureStr);
        double monthlyIncomeVal = Double.parseDouble(monthlyIncomeStr);

        double remainingIncome = monthlyIncomeVal - averageExpenditureVal;

        double invest =0;

        try {
            //Poor: Invest 3%
            if (creditScoreVal >= 300 && creditScoreVal < 580) {
                invest = remainingIncome * 0.3;
            }
            //Fair: Invest 6%
            else if (creditScoreVal >= 580 && creditScoreVal <= 669) {
                invest = remainingIncome * 0.6;
            }
            //Good: Invest 9%
            else if (creditScoreVal >= 670 && creditScoreVal <= 739) {
                invest = remainingIncome * 0.9;
            }
            //Very Good: Invest 12%
            else if (creditScoreVal >= 740 && creditScoreVal <= 799) {
                invest = remainingIncome * 0.12;
            }
            //Exceptional: Invest 15%
            else if (creditScoreVal >= 800 && creditScoreVal <= 850) {
                invest = remainingIncome * 0.15;
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Please enter a valid credit score.", Toast.LENGTH_SHORT).show();

        }
        String investStr = Double.toString(invest);

        Intent intent = new Intent(this, Preferences.class);
        startActivity(intent);


    }

    ActivityResultLauncher<Intent> someActivityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result)
        {
            if(result.getResultCode()== Activity.RESULT_OK){
                Intent data = result.getData();
            }
        }
    });


}