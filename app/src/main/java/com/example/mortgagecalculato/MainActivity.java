package com.example.mortgagecalculato;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText principalAmount = (EditText) findViewById(R.id.principal);
        final EditText interestAmount = (EditText) findViewById(R.id.Interest_group);
        final EditText amortizationPeriod = (EditText) findViewById(R.id.amoritization_period);
        final TextView PrincipalTag = (TextView) findViewById(R.id.princi_symbol);

        Button calculateButton = (Button) findViewById(R.id.next);
        FloatingActionButton settingsButton = findViewById(R.id.settings_button);
        final SharedPreferences userPreferences = getSharedPreferences("userPreferences", MODE_PRIVATE);
        final String currency = userPreferences.getString("currency", "(CAD) Canadian Dollars");

        switch (currency){
            case "(CAD) Canadian Dollars":
                PrincipalTag.setText("CA$");
                break;
            case "(USD) US Dollars":
                PrincipalTag.setText("US$");
                break;
            case "(EUR) Euros":
                PrincipalTag.setText("€");
                break;
            case "(GBP) Pound Sterling":
                PrincipalTag.setText("£");
                break;
        }
        final String symbol = (String) PrincipalTag.getText();


        calculateButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (principalAmount.getText().toString() == null || interestAmount.getText().toString() == null || amortizationPeriod.getText().toString() == null ){
                    Toast.makeText(getApplicationContext(), "All fields must be filled", Toast.LENGTH_LONG).show();
                }else {
                    int principal = Integer.parseInt(principalAmount.getText().toString());
                    double interest = Double.parseDouble(interestAmount.getText().toString());
                    int amortization = Integer.parseInt(amortizationPeriod.getText().toString());


                    int paymentFreq = userPreferences.getInt("payment_freq", 12);


                    String result = Double.toString(CalculateMortgage.calculate(principal, interest, amortization, paymentFreq));

                    Intent toResults = new Intent(v.getContext(), Results.class);
                    toResults.putExtra("payment", result);
                    toResults.putExtra("currency", symbol);
                    toResults.putExtra("paymentFreq", paymentFreq);
                    toResults.putExtra("timePeriod", amortization);
                    startActivity(toResults);
                }
            }
        });

        settingsButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent toSettings = new Intent(v.getContext(), Settings.class);
                startActivity(toSettings);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.help:
                //Steph: this is where the code for the help goes to
                Intent toHelp = new Intent(this.getBaseContext(), Help.class);
                startActivity(toHelp);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
