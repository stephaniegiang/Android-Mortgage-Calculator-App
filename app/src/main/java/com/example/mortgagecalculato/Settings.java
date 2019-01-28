package com.example.mortgagecalculato;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.HashMap;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.Spinner;


public class Settings extends AppCompatActivity {
    final HashMap<String, Integer> paymentFrequency = new HashMap<String, Integer>() {
        {
            put("Daily", 356);
            put("Weekly", 52);
            put("Bi-weekly", 26);
            put("Monthly", 12);
        }
    };


    final HashMap<Integer, Integer> paymentFrequencyPosition = new HashMap<Integer, Integer>() {
        {
            put(356, 0);
            put(52, 1);
            put(26, 2);
            put(12, 3);
        }
    };

    final HashMap<String, Integer> currencyPosition = new HashMap<String, Integer>() {
        {
            put("(CAD) Canadian Dollars", 0);
            put("(USD) US Dollars", 1);
            put("(EUR) Euros", 2);
            put("(GBP) Pound Sterling", 3);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        final Spinner currency = findViewById(R.id.currency);
        final Spinner paymentFreq = findViewById(R.id.payment_frequency);

        Button saveButton = findViewById(R.id.save);

        SharedPreferences userPreferences = getSharedPreferences("userPreferences", MODE_PRIVATE);
        paymentFreq.setSelection(paymentFrequencyPosition.get(userPreferences.getInt("payment_freq", 12)));
        currency.setSelection(currencyPosition.get(userPreferences.getString("currency", "CAD")));


        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences userPreferences = getSharedPreferences("userPreferences", MODE_PRIVATE);
                userPreferences.edit().clear().commit();
                SharedPreferences.Editor prefEditor = userPreferences.edit();
                prefEditor.putString("currency", currency.getSelectedItem().toString());
                prefEditor.putInt("payment_freq", paymentFrequency.get(paymentFreq.getSelectedItem().toString()));
                prefEditor.commit();
            }
        });
    }
}
