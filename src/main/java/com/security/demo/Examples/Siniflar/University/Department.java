package com.security.demo.Examples.Siniflar.University;

public class Department {
    private String name;
    Professor head;
    Course [] courses;
    Student [] students;


    public Department() {
    }

    public Department(String name, Professor head, Course[] courses, Student[] students) {
        this.name = name;
        this.head = head;
        this.courses = courses;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getHead() {
        return head;
    }

    public void setHead(Professor head) {
        this.head = head;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
