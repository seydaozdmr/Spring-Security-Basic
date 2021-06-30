package com.security.demo.Examples.Siniflar.AbstractStudent;

import java.util.Date;

public class GraduatedStudent extends AbstractStudent{
    private String advisor;
    private String thesis;

    public GraduatedStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis) {
        super(no, name, year, dob, major);
        this.advisor = advisor;
        this.thesis = thesis;
    }

    @Override
    public void study() {

    }

    @Override
    public void register() {

    }

    public void writeThesis(){}
    public void meetWithAdvisor(){}

    public String getAdvisor() {
        return advisor;
    }

    public String getThesis() {
        return thesis;
    }
}
