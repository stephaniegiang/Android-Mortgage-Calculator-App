package com.example.mortgagecalculato;

public class CalculateMortgage {
    final int monthlyPayment = 12;

    static public double calculate (int principalAmount, double interest, int totalPeriod){
        int totalPayments = totalPeriod * 12;
        double monthlyInterest = (interest/100)/12;

        double interestPortion = Math.pow(1+monthlyInterest, totalPayments);
        double result = principalAmount * ((monthlyInterest * interestPortion )/(interestPortion - 1));
        return Math.round(result * 100.00)/100.00;
    }
}
