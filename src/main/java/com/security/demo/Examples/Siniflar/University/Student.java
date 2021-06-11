package com.security.demo.Examples.Siniflar.University;

public class Student {
    private int no;
    private String name;
    private String dob; //doğum tarihi
    Department department;
    Professor professor;
    private Course[] courses;

    public Student() {

    }

    public Student(int no, String name, String dob, Department department, Professor professor, Course[] courses) {
        this.no = no;
        this.name = name;
        this.dob = dob;
        this.department = department;
        this.professor = professor;
        this.courses = courses;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
}
