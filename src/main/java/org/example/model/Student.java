package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String program;
    private TuitionFeePayment paymentTransaction;
    private List<Course> courseList;

    // No-args Constructor
    public Student(){
        super();
        this.paymentTransaction = new TuitionFeePayment();
        this.courseList = new ArrayList<>();
    }

    // Constructor
    public Student(String PersonID, String PersonName, String program){
        super(PersonID, PersonName);
        this.program = program;
        this.paymentTransaction = new TuitionFeePayment();
        this.courseList = new ArrayList<>();
    }

    public void setProgram(String program){
        this.program = program;
    }

    public String getProgram(){
        return program;
    }

    public TuitionFeePayment getPaymentTransaction() {
        return paymentTransaction;
    }


    @Override
    public void mainTask() {
        System.out.println("Studying " + program);
    }
}