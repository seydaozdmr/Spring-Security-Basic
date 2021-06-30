package com.security.demo.Examples.Siniflar.AbstractStudent;

import java.util.Date;

public class VocationalStudent extends AbstractStudent{

    public VocationalStudent(int no, String name, int year, Date dob, String major) {
        super(no, name, year, dob, major);
    }

    @Override
    public void study() {

    }

    @Override
    public void register() {

    }

    @Override
    public String toString() {
        return "VocationalStudent{"+ getNo() +" "+ getName() +" "+ getYear()+ " "+ getDob() + " "+ getMajor()+" }";
    }
}
