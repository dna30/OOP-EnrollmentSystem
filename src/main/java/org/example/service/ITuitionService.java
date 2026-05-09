package org.example.service;

import org.example.model.Student;

public interface ITuitionService {
    double calculateFee(Student s, int units, double discount);

    void processPayment(Student s, double amount);

    double getBalance(Student s);
}