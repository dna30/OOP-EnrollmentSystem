package org.example.service;

import org.example.model.Course;

public interface CourseReg {
    void addCourse(Course course);
    void displayAllCourse();
    void updateCourse(Course course);
    String deleteCourse(Course course);
    Course getCourse(String courseID);
}
