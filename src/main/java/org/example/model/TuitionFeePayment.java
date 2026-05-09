package org.example.model;

public class TuitionFeePayment {
    private double pricePerUnit = 1000.00;
    private double balance;
    private double totalTuition;

    public TuitionFeePayment() {}

    //Getters and Setters
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public double getTotalTuition() { return totalTuition; }
    public void setTotalTuition(double totalTuition) { this.totalTuition = totalTuition; }
    public double getPricePerUnit() { return pricePerUnit; }
}