package com.example.vthacks_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText creditScore;
    private EditText averageExpenditure;
    private EditText monthlyIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        double invest;

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
    }
}