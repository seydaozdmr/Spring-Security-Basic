package com.security.demo.Examples.Siniflar.AbstractStudent;

import java.util.Date;

public class PhdStudent extends GraduatedStudent{

    private boolean qualifyingExamTaken ;

    public PhdStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis,boolean qualifyingExamTaken) {
        super(no, name, year, dob, major, advisor, thesis);
        this.qualifyingExamTaken=qualifyingExamTaken;
    }

    public boolean isQualifyingExamTaken(){
        return qualifyingExamTaken;
    }

    @Override
    public void study() {
        super.study();
    }

    @Override
    public void register() {
        super.register();
    }

    @Override
    public void writeThesis() {
        super.writeThesis();
    }

    @Override
    public void meetWithAdvisor() {
        super.meetWithAdvisor();
    }
}
