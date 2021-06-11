package com.security.demo.Examples.Siniflar.University;

public class Classroom {
    private int id;
    private String name;
    private String grade;
    private Student [] students;
    private Course [] givenCourses;
    private Professor professor;

    public Classroom() {
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Course[] getGivenCourses() {
        return givenCourses;
    }

    public void setGivenCourses(Course[] givenCourses) {
        this.givenCourses = givenCourses;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
