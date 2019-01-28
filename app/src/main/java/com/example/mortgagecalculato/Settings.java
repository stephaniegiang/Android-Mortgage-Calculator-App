package com.example.mortgagecalculato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;
import java.util.Map;


public class Settings extends AppCompatActivity {
    private static final Map<String, Integer> PAYMENTFREQUENCY = Map.ofEntries(
            entry("Daily", 365),
            entry("Weekly", 52),
            entry("Bi-weekly", 104),
            entry("Montly", 12)

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }
}
