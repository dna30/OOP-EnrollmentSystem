package org.example.service;

import org.example.model.Student;
import org.example.model.TuitionFeePayment;

public class TuitionServiceImpl implements ITuitionService {

    @Override
    public double calculateFee(Student s, int units, double discount) {
        TuitionFeePayment p = s.getPaymentTransaction();
        if (p == null) {
            return 0.0;
        }

        double total = (units * p.getPricePerUnit()) * (1.0 - discount);

        p.setTotalTuition(total);
        p.setBalance(total);

        return total;
    }

    @Override
    public void processPayment(Student s, double amount) {
        TuitionFeePayment p = s.getPaymentTransaction();
        if (p != null) {
            double currentBalance = p.getBalance();
            p.setBalance(Math.max(0, currentBalance - amount));
        }
    }

    @Override
    public double getBalance(Student s) {
        if (s != null && s.getPaymentTransaction() != null) {
            return s.getPaymentTransaction().getBalance();
        }
        return 0.0;
    }
}