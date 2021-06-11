package com.security.demo.Examples.Siniflar.University;

import java.time.LocalDate;

public class Course {
    private String code;
    private String name;
    Department department;
    Professor professor;
    Student [] students;
    String [] days;
    LocalDate localDate;
    private Classroom classroom;



    public Course() {
    }

    public Course(String code, String name, Department department, Professor professor, Student[] students, String[] days, LocalDate localDate) {
        this.code = code;
        this.name = name;
        this.department = department;
        this.professor = professor;
        this.students = students;
        this.days = days;
        this.localDate = localDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String[] getDays() {
        return days;
    }

    public void setDays(String[] days) {
        this.days = days;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
