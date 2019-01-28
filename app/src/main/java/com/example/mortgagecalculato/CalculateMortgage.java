package com.example.mortgagecalculato;

public class CalculateMortgage {

    static public double calculate (int principalAmount, double interest, int totalPeriod){
        int paymentFrequency = Settings.getPaymentFrequency();

        int totalPayments = totalPeriod  * paymentFrequency;
        double monthlyInterest = (interest/100)/12;

        double interestPortion = Math.pow(1+monthlyInterest, totalPayments);
        double result = principalAmount * ((monthlyInterest * interestPortion )/(interestPortion - 1));
        return Math.round(result * 100.00)/100.00;
    }
}
