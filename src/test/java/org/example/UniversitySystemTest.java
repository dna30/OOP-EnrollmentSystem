package org.example;

import org.example.service.*;
import org.junit.jupiter.api.Test;
import org.example.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class UniversitySystemTest {

    @Test
    public void testEnrollmentCapacity_ThrowsException() {
        Section section = new Section("S1", "BSIT-1A", 1);
        Student s1 = new Student("101", "Alice", "IT");
        Student s2 = new Student("102", "Bob", "IT");
        IEnrollmentService service = new EnrollmentServiceImpl();

        assertDoesNotThrow(() -> service.enrollStudentInSection(s1, section));
        assertThrows(SectionFullException.class, () -> service.enrollStudentInSection(s2, section));
    }

    @Test
    public void testTuitionCalculation_ServiceLogic() {
        Student s = new Student("101", "Alice", "IT");
        ITuitionService service = new TuitionServiceImpl();

        double total = service.calculateFee(s, 5, 0.0);
        assertEquals(5000.0, s.getPaymentTransaction().getTotalTuition());
    }

    @Test
    public void testPayment_BalanceReduction() {
        Student s = new Student("101", "Alice", "IT");
        ITuitionService service = new TuitionServiceImpl();
        service.calculateFee(s, 1, 0.0);
        service.processPayment(s, 400.0);

        assertEquals(600.0, service.getBalance(s));
    }

    @Test
    public void testInstructorAssignment() {
        Instructor i = new Instructor("I01", "Dr. Smith", "CS");
        Section s = new Section("S1", "BSIT-1A", 30);
        s.setInstructor(i);
        assertEquals("Dr. Smith", s.getInstructor().getPersonName());
    }

    @Test
    public void testDepartmentSectionStorage() {
        Department dept = new Department("D1", "CCS");
        Section sec = new Section("S1", "BSIT-1A", 30);
        dept.getSections().add(sec);
        assertEquals(1, dept.getSections().size());
    }
}