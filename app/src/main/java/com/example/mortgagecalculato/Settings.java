package com.example.mortgagecalculato;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        final Spinner currency = findViewById(R.id.currency);
        final Spinner paymentFrew = findViewById(R.id.payment_frequency);

        Button saveButton = findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences userPreferences = getSharedPreferences("userpreferences", MODE_PRIVATE);
                userPreferences.edit().clear().commit();
                SharedPreferences.Editor prefEditor = userPreferences.edit();
                prefEditor.putString("currency", currency.getSelectedItem().toString());
                prefEditor.putInt("payment_freq", paymentFrequency.get(paymentFrew.getSelectedItem().toString()));
                prefEditor.commit();
            }
        });
    }
}
