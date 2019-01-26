package com.example.mortgagecalculato;

public class MortgageCalculator {
    public double calculate (int principal_amount, double monthly_interest, int total_payments){
        double interestPortion = Math.pow(1+monthly_interest, total_payments);
        return principal_amount * ((monthly_interest * interestPortion )/(interestPortion - 1));
    }
}
