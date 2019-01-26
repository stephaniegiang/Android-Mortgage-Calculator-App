package com.example.mortgagecalculato;

public class CalculateMortgage {
    static public double calculate (int principalAmount, double interest, int totalPeriod){
        int totalPayments = totalPeriod * 12;
        double monthly_interest = (interest/100)/12;

        double interestPortion = Math.pow(1+monthly_interest, totalPayments);
        return principalAmount * ((monthly_interest * interestPortion )/(interestPortion - 1));
    }
}
