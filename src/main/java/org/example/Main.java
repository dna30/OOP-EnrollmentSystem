package org.example;

import org.example.model.*;
import org.example.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRegistrationInterface studentRegistrationInterface = new StudentRegistration();
        CourseRegistration courseRegistration = new CourseRegistration();
        Department bsit = new Department("D1", "College of Information Technology");
        ITuitionService tuitionService = new TuitionServiceImpl();
        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();

        CampusRegistrar campusRegistrar = new CampusRegistrar(studentRegistrationInterface, courseRegistration);
        
        boolean validMainChoice = false;

        while (!validMainChoice) {
            System.out.println("\n---MAIN MENU---\n");
            System.out.println("A. Student Registration");
            System.out.println("B. Course Registration");
            System.out.println("C. Tuition Fee Payment");
            System.out.println("D. Institutional Hierarchy");
            System.out.println("E. Exit");

            System.out.print("Enter Choice: ");
            String mainChoice = scanner.nextLine();

            if (mainChoice.equalsIgnoreCase("A")) {

                boolean isStudentMenu = true;
                while (isStudentMenu) {
                System.out.println("\n---STUDENT REGISTRATION---");
                System.out.println("[1] Save Student");
                System.out.println("[2] Display Student");
                System.out.println("[3] Update Student");
                System.out.println("[4] Remove Student");
                System.out.println("[5] Create New Section");
                System.out.println("[6] Enroll Student in Section");
                System.out.println("[7] Back to Main Menu");

                System.out.print("Enter Choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("\nEnter Student ID: ");
                        String ID = scanner.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Student Program: ");
                        String program = scanner.nextLine();

                        campusRegistrar.addStudent(new Student(ID, name, program));
                        System.out.println();
                        break;

                    case "2":
                        System.out.println();
                        campusRegistrar.displayAll();
                        break;

                    case "3":
                        System.out.print("\nEnter Student ID to update: ");
                        String updateID = scanner.nextLine();

                        Student studentToUpdate = new Student();
                        studentToUpdate.setPersonID(updateID);
                        campusRegistrar.updateStudent(studentToUpdate);
                        break;

                    case "4":
                        System.out.print("\nEnter Student ID to remove: ");
                        String removeID = scanner.nextLine();

                        Student studentToRemove = new Student();
                        studentToRemove.setPersonID(removeID);
                        System.out.println(campusRegistrar.delete(studentToRemove));
                        break;

                    case "5":
                        System.out.print("\nEnter Section ID: ");
                        String sId = scanner.nextLine();
                        System.out.print("Enter Section Name (e.g., IT2C): ");
                        String sName = scanner.nextLine();
                        System.out.print("Enter Capacity: ");
                        int cap = Integer.parseInt(scanner.nextLine());

                        Section newSection = new Section(sId, sName, cap);
                        bsit.getSections().add(newSection);
                        System.out.println("Section " + sName + " added to " + bsit.getDeptName());
                        break;

                    case "6":
                        System.out.print("\nEnter Student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Enter Section Name: ");
                        String targetSection = scanner.nextLine();

                        Student studentToEnroll = campusRegistrar.getStudent(studentId);

                        Section selectedSection = null;
                        for(Section s : bsit.getSections()) {
                            if(s.getSectionName().equalsIgnoreCase(targetSection)) {
                                selectedSection = s;
                                break;
                            }
                        }

                        if (studentToEnroll != null && selectedSection != null) {
                            try {
                                enrollmentService.enrollStudentInSection(studentToEnroll, selectedSection);
                                System.out.println("Success: Enrolled in " + targetSection);
                            } catch (SectionFullException e) {
                                System.out.println("ERROR: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Student or Section not found!\n");
                        }
                        break;

                    case "7":
                        isStudentMenu = false;
                        break;

                    default:
                        System.out.println("Invalid Choice. Please try again.\n");
                        break;
                    }
                }
            } else if (mainChoice.equalsIgnoreCase("B")) {

                boolean isCourseMenu = true;
                while (isCourseMenu) {
                System.out.println("\n---COURSE REGISTRATION---");
                System.out.println("[1] Save Course");
                System.out.println("[2] Display Course");
                System.out.println("[3] Update Course");
                System.out.println("[4] Remove Course");
                System.out.println("[5] Back to Main Menu");

                System.out.print("Enter Choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("\nEnter Course ID: ");
                        String courseID = scanner.nextLine();

                        System.out.print("Enter Course Name: ");
                        String courseName = scanner.nextLine();

                        System.out.print("Enter Course Program: ");
                        String courseProgram = scanner.nextLine();

                        Course newCourse = new Course(courseID, courseName, courseProgram);

                        System.out.print("Enter Instructor Name: ");
                        String instructorName = scanner.nextLine();

                        Instructor courseInstructor = new Instructor("Instructor: " + courseID, instructorName, courseProgram);
                        newCourse.setInstructor(courseInstructor);

                        System.out.print("Enter Section Name to assign this Instructor to (e.g., IT2B): ");
                        String targetSectionName = scanner.nextLine();

                        boolean sectionFound = false;
                        for (Section s : bsit.getSections()) { // Assuming 'bsit' is your Department object
                            if (s.getSectionName().equalsIgnoreCase(targetSectionName)) {
                                s.setInstructor(courseInstructor); // This replaces "TBA" in the Hierarchy
                                sectionFound = true;
                                break;
                            }
                        }

                        if (!sectionFound) {
                            System.out.println("Note: Section not found. Instructor assigned to Course only.");
                        }

                        System.out.print("Instructor Role: ");
                        campusRegistrar.addCourse(newCourse);
                        courseInstructor.mainTask();
                        System.out.println("\nCourse and Instructor successfully registered!");
                        break;

                    case "2":
                        System.out.println();
                        campusRegistrar.displayAllCourse();
                        break;

                    case "3":
                        System.out.print("\nEnter Course ID to update: ");
                        String updateCID = scanner.nextLine();

                        Course courseToUpdate = new Course();
                        courseToUpdate.setcourseID(updateCID);
                        campusRegistrar.updateCourse(courseToUpdate);
                        break;

                    case "4":
                        System.out.print("\nEnter Course ID to remove: ");
                        String removeID = scanner.nextLine();

                        Course courseToRemove = new Course();
                        courseToRemove.setcourseID(removeID);
                        System.out.println(campusRegistrar.deleteCourse(courseToRemove));
                        break;

                    case "5":
                        isCourseMenu = false;
                        break;

                    default:
                        System.out.println("\nInvalid Choice. Please try again.");
                        break;
                    }
                }
            } else if (mainChoice.equalsIgnoreCase("C")) {

                boolean isTuitionMenu = true;
                while (isTuitionMenu) {
                System.out.println("\n---TUITION PAYMENT---");
                System.out.print("Enter Student ID: ");
                String studentID = scanner.nextLine();

                Student currentStudent = campusRegistrar.getStudent(studentID);

                if (currentStudent == null){
                    System.out.println("Student not found! Please REGISTER the student in Main Menu: 'A'. Thank you!");

                    isTuitionMenu = false;

                } else {
                    System.out.println("Student Found: " + currentStudent.getPersonName());
                    System.out.println("[1] Choose Plan");
                    System.out.println("[2] Make Payment");
                    System.out.println("[3] Check Balance");

                    System.out.print("Enter Choice: ");
                    String tuitionChoice = scanner.nextLine();

                    TuitionFeePayment transaction = currentStudent.getPaymentTransaction();

                    switch (tuitionChoice) {
                        case "1":
                            System.out.print("Enter total number of units: ");
                            int units = Integer.parseInt(scanner.nextLine());

                            System.out.println("\nChoose Payment Plan:");
                            System.out.println("Plan A: Full Payment (3% discount)");
                            System.out.println("Plan B: Quarterly Payment");
                            System.out.println("Plan C: Monthly Payment");

                            System.out.print("Select Plan (A/B/C): ");
                            String plan = scanner.nextLine().toUpperCase();

                            double discount = 0.0;
                            if (plan.equalsIgnoreCase("A")){
                                discount = 0.03;
                            } else if (plan.equalsIgnoreCase("B") || plan.equalsIgnoreCase("C")){
                                discount = 0.00;
                            } else {
                                System.out.println("Invalid Payment Plan Selected. Please try again. \n");
                            break;
                        }

                        double total = tuitionService.calculateFee(currentStudent, units, discount);
                        System.out.println("\nTotal Tuition: " + total);

                        if (plan.equalsIgnoreCase("B")){
                            System.out.println("Quarterly Payment Amount (4 terms): " + (total / 4));
                        }else if (plan.equalsIgnoreCase("C")) {
                            System.out.println("Monthly payment amount (10 months): " + (total / 10));
                        }

                        System.out.println("\n--- Proceeding to Payment ---");
                        System.out.print("Enter Payment Amount: ");
                        double amount = Double.parseDouble(scanner.nextLine());

                        tuitionService.processPayment(currentStudent, amount);
                        System.out.println("Payment Applied!");

                        System.out.println("Remaining Balance: " + tuitionService.getBalance(currentStudent));

                        System.out.println("\nReturning to Main Menu...");
                        isTuitionMenu = false;

                        break;

                        case "2":
                            System.out.print("Enter Payment Amount: ");
                            double amountFull = Double.parseDouble(scanner.nextLine());

                            tuitionService.processPayment(currentStudent, amountFull);
                            System.out.println("Payment Applied!");
                            System.out.println("Remaining Balance: " + tuitionService.getBalance(currentStudent));

                            System.out.println("\nReturning to Main Menu...");
                            isTuitionMenu = false;
                            break;

                        case "3":
                            double balance = tuitionService.getBalance(currentStudent);
                            System.out.println("Current Remaining Balance: " + balance);
                            isTuitionMenu = false;
                            break;

                        default:
                            System.out.println("Invalid Choice. Please try again. \n");
                            break;
                            }
                         }
                    }
                } else if (mainChoice.equalsIgnoreCase("D")) {
                    System.out.println("\n--- INSTITUTIONAL HIERARCHY ---");
                    System.out.println("Department: " + bsit.getDeptName());

                    if (bsit.getSections().isEmpty()) {
                        System.out.println("No sections found in this department.");
                    }

                    for (Section s : bsit.getSections()) {
                        System.out.println("  └── Section: " + s.getSectionName() + " (Capacity: " + s.getMaxCapacity() + ")");
                        System.out.println("      ├── Instructor: " + (s.getInstructor() != null ? s.getInstructor().getPersonName() : "TBA"));
                        System.out.println("      └── Students Enrolled: " + s.getEnrolledStudents().size());

                        for (Student enrolled : s.getEnrolledStudents()) {
                            System.out.println("          - " + enrolled.getPersonName() + " (" + enrolled.getPersonID() + ")");
                        }
                    }
            } else if (mainChoice.equalsIgnoreCase("E")) {
                System.out.println("Program Terminated.");
                validMainChoice = true;
                } else {
                    System.out.println("Invalid Choice. Please try again. \n");
            }
        }
        scanner.close();
    }
}