package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration implements StudentRegistrationInterface {
    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void addStudent(Student student) {
        studentArrayList.add(student);
    }

    @Override
    public void displayAll() {
        if (studentArrayList.isEmpty()){
            System.out.println("There are no students registered yet.");
            return;
        }

        System.out.println("\n---LIST OF REGISTERED STUDENTS---");
        for (Student s : studentArrayList){
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Student Name: " + s.getPersonName());
            System.out.println("Student Program: " + s.getProgram());

            s.mainTask();
            System.out.println();
        }
    }


    @Override
    public void  updateStudent(Student student){
        boolean found = false;
        for (int i = 0; i < studentArrayList.size(); i++) {
            if(studentArrayList.get(i).getPersonID().equals(student.getPersonID())){
                System.out.print("Enter New Student Name: ");
                String newStudentName = scanner.nextLine();

                System.out.print("Enter New Program: ");
                String newProgram = scanner.nextLine();

                Student existingStudent = studentArrayList.get(i);
                existingStudent.setPersonName(newStudentName);
                existingStudent.setProgram(newProgram);

                found = true;
                System.out.println("Successfully Updated!\n");
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found!\n");
        }
    }

    @Override
    public String delete(Student student){
        for(int i = 0; i < studentArrayList.size(); i++){
            if(studentArrayList.get(i).getPersonID().equals(student.getPersonID())){
                studentArrayList.remove(i);
                return "Successfully Deleted!\n";
            }
        }
        return "No such student found!\n";
    }

    @Override
    public Student getStudentByID(String personID) {
        return getStudent(personID);
    }

    @Override
    public Student getStudent(String personID){
        for (Student s : studentArrayList){
            if(s.getPersonID().equals(personID)){
                return s;
            }
        }
        return null;
    }
}