package com.security.demo.Examples.Siniflar.AbstractStudent;

import java.util.Date;

public class UndergraduteStudent extends AbstractStudent{
    private String minor;

    public UndergraduteStudent(int no, String name, int year, Date dob, String major, String minor) {
        super(no, name, year, dob, major);
        this.minor = minor;
    }

    @Override
    public void study() {

    }

    @Override
    public void register() {

    }

    @Override
    public String toString() {
        return"UndergraduteStudent{ "+ getNo() +" "+
                getName() +" "+
                getYear()+ " "+
                getDob() + " "+
                getMajor()+" " +
                "minor='" + minor + '\'' +
                '}';
    }

    public String getMinor() {
        return minor;
    }
}
