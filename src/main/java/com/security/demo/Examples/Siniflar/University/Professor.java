package com.security.demo.Examples.Siniflar.University;

public class Professor {
    private int id;
    private String name;
    private String dob; //doğum tarihi
    private String rank;
    Department department;
    Student [] students;
    Course [] courses;

    public Professor() {
    }

    public Professor(int id, String name, String dob, String rank, Department department, Student[] students, Course[] courses) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.rank = rank;
        this.department = department;
        this.students = students;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
}
