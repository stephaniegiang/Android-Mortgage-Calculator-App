package com.example.mortgagecalculato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;


public class Settings extends AppCompatActivity {
    final HashMap<String, Integer> paymentFrequency = new HashMap<String, Integer>() {
        {
            put("Daily", 356);
            put("Weekly", 52);
            put("Bi-weekly", 26);
            put ("Monthly", 12);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }

}
