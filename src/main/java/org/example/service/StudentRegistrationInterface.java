package org.example.service;

import org.example.model.Student;

public interface StudentRegistrationInterface {
    void addStudent(Student student);
    void displayAll();
    void updateStudent(Student student);
    String delete(Student student);
    Student getStudentByID(String personID);

    // Finder for the Tuition in Menu C
    Student getStudent(String personID);
}
