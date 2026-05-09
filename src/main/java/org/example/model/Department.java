package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String deptID;
    private String deptName;

    private List<Section> sections;

    private List<Instructor> instructors;

    public Department(String deptID, String deptName) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.sections = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }
}
