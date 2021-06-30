package com.security.demo.Examples.Siniflar.AbstractStudent;

import java.util.Date;

public abstract class AbstractStudent implements Student{
    private int no;
    private String name;
    private int year;
    private Date dob;
    private String major;

    public AbstractStudent(int no, String name, int year, Date dob, String major) {
        this.no = no;
        this.name = name;
        this.year = year;
        this.dob = dob;
        this.major = major;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Date getDob() {
        return dob;
    }

    public String getMajor() {
        return major;
    }
}
