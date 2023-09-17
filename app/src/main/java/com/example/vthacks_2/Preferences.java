package com.example.vthacks_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Preferences extends AppCompatActivity {
    private String[] FAANG = {"Facebook\n", "Amazon\n", "Apple\n", "Netflix\n", "Google\n"};
    private String[] real_estate = {"CoStar\n", "Prologis, Inc.\n", "American Tower Corporation\n"};
    private String[] information_tech = {"NVIDIA Corporation\n", "Broadcom Inc.\n", "Adobe Inc.\n"};
    private String[] healthcare = {"Pfizer\n", "CVS Pharmacy\n", "Stryker Corporation\n"};
    private String[] financials = {"Capital One\n", "Bank of America Corporation\n", "JPMorgan Chase & Co.\n"};
    private String[] energy = {"Exxon Mobil Corporation\n", "TotalEnergies SE", "NextEra Energy Inc.\n"};
    private String[] defensive = {"General Dynamics Corporation\n", "Northrop Grumman Corporation\n", "Boeing Co.\n"};
    private String[] agro_food = {"Coca-Cola Co\n", "Fresh Del Monte Produce Inc.\n", "Tyson Foods, Inc.\n"};

    private boolean clickedFAANG = false;
    private boolean clickedRealEstate = false;
    private boolean clickedInformationTech = false;
    private boolean clickedHealthcare = false;
    private boolean clickedFinancials = false;
    private boolean clickedEnergy = false;
    private boolean clickedDefensive = false;
    private boolean clickedAgroAndFood = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
    }

    public void checkFAANG(View v) {
        clickedFAANG = true;
    }

    public void checkRealEstate(View v) {
        clickedRealEstate = true;
    }

    public void checkInformationTech(View v) {
        clickedInformationTech = true;
    }

    public void checkHealthcare(View v) {
        clickedHealthcare = true;
    }

    public void checkFinancials(View v) {
        clickedFinancials = true;
    }

    public void checkEnergy(View v) {
        clickedEnergy = true;
    }

    public void checkDefensive(View v) {
        clickedDefensive = true;
    }

    public void checkAgroAndFood(View v) {
        clickedAgroAndFood = true;
    }

    public void clickNext(View v) {
        if (clickedFAANG == true) {

        }
        else if (clickedRealEstate == true) {

        }
        else if (clickedInformationTech == true) {

        }
        else if (clickedHealthcare == true) {

        }
        else if (clickedFinancials == true) {

        }
        else if (clickedEnergy == true) {

        }
        else if (clickedDefensive == true) {

        }
        else if (clickedAgroAndFood == true) {

        }
    }

}