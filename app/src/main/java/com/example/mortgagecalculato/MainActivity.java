package com.example.mortgagecalculato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText principalAmount = (EditText) findViewById(R.id.principal);
        final EditText interestAmount = (EditText) findViewById(R.id.Interest_group);
        final EditText amortizationPeriod = (EditText) findViewById(R.id.amoritization_period);

        Button calculateButton = (Button) findViewById(R.id.next);

        calculateButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                int principal = Integer.parseInt(principalAmount.getText().toString());
                double interest = Double.parseDouble(interestAmount.getText().toString());
                int amortization = Integer.parseInt(amortizationPeriod.getText().toString());

                String result = Double.toString(CalculateMortgage.calculate(principal, interest, amortization));
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });
    }
}
