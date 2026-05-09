# Interface-Driven Enrollment System (Capstone Project)

---
**Developed by**: Alysson Ninette Dimaano

---
**Description:** A robust, CLI-based enrollment system built with Java following the architecture principles. This project manages student registrations, course assignments, tuition fee processing, and institutional hierarchies.

***`Features`***

- **Comprehensive CRUD**: Manage Students, Courses, and Instructors via in-memory storage (ArrayList).

- **Capacity Validation**: Automated checks to prevent over-enrollment using custom SectionFullException.

- **Tuition Management**: Calculates fees based on units, supports payment plans (A/B/C), and tracks remaining balances.

- **Institutional Hierarchy**: A nested view of Departments -> Sections -> Assigned Instructors -> Enrolled Students.

- **Automated Testing**: 5+ JUnit 5 test cases ensuring business logic reliability.

`System Demonstration `

**1. This focuses on students who are already registered.**

![List Of Students Registered.png](src/main/resources/images/List%20Of%20Students%20Registered.png)

**2. This shows course registration and instructor assignment.**

![Course Registration.png](src/main/resources/images/Course%20Registration.png)

**3. Institutional Hierarchy: Mapping Departments to Sections, Instructors, and Students.**

![Hierarchy View.png](src/main/resources/images/Hierarchy%20View.png)

**4. The Validation & Error Handling in Section's Capacity.**

![Full Capacity Section Handling.png](src/main/resources/images/Full%20Capacity%20Section%20Handling.png)

**5. Tuition Fee: showcasing different plans (A/B/C).**

**Note: Plan A includes a 3% discount calculation.**

![TF Plan A.png](src/main/resources/images/TF%20Plan%20A.png)
![TF Plan B.png](src/main/resources/images/TF%20Plan%20B.png)
![TF Plan C.png](src/main/resources/images/TF%20Plan%20C.png)

**6. A Java-based University Enrollment System project that handles student enrollment, course sections, instructors, and tuition processing using OOP concepts with JUnit 5 testing.**

![SystemTest(JUnit).png](src/main/resources/images/SystemTest%28JUnit%29.png)

---