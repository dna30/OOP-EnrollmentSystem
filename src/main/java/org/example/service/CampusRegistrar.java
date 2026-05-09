package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

public class CampusRegistrar {
    private StudentRegistrationInterface studentRegistration;
    private CourseReg courseRegistration;

    // Student
    public CampusRegistrar(StudentRegistrationInterface studentRegistration, CourseReg courseRegistration) {
        this.studentRegistration = studentRegistration;
        this.courseRegistration = courseRegistration;
    }

    public String addStudent(Student student) {
        studentRegistration.addStudent(student);
        return "Student Successfully Saved!";
    }

    public void displayAll() {
        studentRegistration.displayAll();
    }

    public void updateStudent(Student student) {
        studentRegistration.updateStudent(student);
    }

    public String delete(Student student) {
        return studentRegistration.delete(student);
    }

    public Student findStudent(String personID) {
        return studentRegistration.getStudent(personID);
    }

    public Student getStudent(String personID) {
        return studentRegistration.getStudent(personID);
    }

    // Courses
    public void addCourse(Course course) {
        courseRegistration.addCourse(course);
    }

    public void displayAllCourse() {
        courseRegistration.displayAllCourse();
    }

    public void updateCourse(Course course) {
        courseRegistration.updateCourse(course);
    }

    public String deleteCourse(Course course) {
        return courseRegistration.deleteCourse(course);
    }

    public Course getCourse(String courseID) {
        return courseRegistration.getCourse(courseID);
    }

}
