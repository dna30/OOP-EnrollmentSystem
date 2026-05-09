package org.example.service;

import org.example.model.*;
import org.example.service.IEnrollmentService;
import org.example.service.SectionFullException;

public class EnrollmentServiceImpl implements IEnrollmentService {
    @Override
    public void enrollStudentInSection(Student student, Section section) throws SectionFullException {
        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            throw new SectionFullException(section.getSectionName() + " is at full capacity (" + section.getMaxCapacity() + ")!");
        }

        section.getEnrolledStudents().add(student);
    }

    @Override
    public void viewDepartmentHierarchy(Department dept) {
        System.out.println("Department: " + dept.getDeptName());
        for (Section s : dept.getSections()) {
            System.out.println("  └── Section: " + s.getSectionName());

            Instructor i = s.getInstructor();
            System.out.println("      ├── Instructor: " + (i != null ? i.getPersonName() : "None"));
        }
    }
}