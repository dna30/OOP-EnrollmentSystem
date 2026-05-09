package org.example.model;

public class Course {
    private String courseID;
    private String courseName;
    private String courseProgram;
    private Instructor instructor;

    public Course() {
    }

    public Course(String courseID, String courseName, String courseProgram) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseProgram = courseProgram;
    }

    public String getcourseID() {
        return courseID;
    }

    public String getcourseName() {
        return courseName;
    }

    public String getCourseProgram() {
        return courseProgram;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setcourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setcourseProgram(String courseProgram) {
        this.courseProgram = courseProgram;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}