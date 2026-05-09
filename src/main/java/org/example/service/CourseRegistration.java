package org.example.service;

import org.example.model.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration implements CourseReg {
    private ArrayList<Course> courseArrayList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void addCourse(Course course){
        courseArrayList.add(course);
    }

    @Override
    public void displayAllCourse() {
        if (courseArrayList.isEmpty()){
            System.out.println("There are no courses registered yet.");
            return;
        }

        System.out.println("\n---LIST OF REGISTERED COURSES---");
        for (Course c : courseArrayList){
            System.out.println("Course ID: " + c.getcourseID());
            System.out.println("Course Name: " + c.getcourseName());
            System.out.println("Course Program: " + c.getCourseProgram());

            if (c.getInstructor() != null) {
                System.out.println("Instructor: " + c.getInstructor().getPersonName());
                c.getInstructor().mainTask();
            } else {
                System.out.println("Instructor: Not assigned yet.");
            }
            System.out.println();
        }
    }

    @Override
    public void  updateCourse(Course course){
        boolean found = false;
        for (int i = 0; i < courseArrayList.size(); i++) {
            if(courseArrayList.get(i).getcourseID().equals(course.getcourseID())){
                System.out.print("Enter New Course Name: ");
                String newCourse = scanner.nextLine();

                System.out.print("Enter New Program: ");
                String newProgram = scanner.nextLine();

                Course existingStudent = courseArrayList.get(i);
                existingStudent.setcourseName(newCourse);
                existingStudent.setcourseProgram(newProgram);

                found = true;
                System.out.print("Successfully Updated!\n");
                break;
            }
        }
        if (!found){
            System.out.println("Course Not Found!\n");
        }
    }

    @Override
    public String deleteCourse(Course course){
        for(int i = 0; i < courseArrayList.size(); i++){
            if(courseArrayList.get(i).getcourseID().equals(course.getcourseID())){
                courseArrayList.remove(i);
                return "Successfully Deleted!";
            }
        }
        return "No such course exists!";
    }

    @Override
    public Course getCourse(String courseID) {
        for (Course c : courseArrayList){
            if (c.getcourseID().equals(courseID)){
                return c;
            }
        }
        return null;
    }
}