package com.example.mortgagecalculato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class Results extends AppCompatActivity {

    final HashMap<Integer, String> paymentFrequency = new HashMap<Integer, String>() {
        {
            put(356, "Daily");
            put(52, "Weekly");
            put(26, "Bi-weekly");
            put(12, "Monthly");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView resultField = findViewById(R.id.results);

        String payment = getIntent().getStringExtra("payment");
        String currency = getIntent().getStringExtra("currency");
        String paymentFreq = paymentFrequency.get(getIntent().getIntExtra("paymentFreq", 0));
        int timePeriod = getIntent().getIntExtra("timePeriod", 0);

        String resultText =
                paymentFreq + " payments of $" + payment + " " + currency + " will have to be made over " + timePeriod + " year(s).";

        resultField.setText(resultText);
    }
}
