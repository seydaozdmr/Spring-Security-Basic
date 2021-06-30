package com.security.demo.Examples.Siniflar.AbstractStudent;

import java.util.Date;

public class MasterStudent extends GraduatedStudent{

    public MasterStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis) {
        super(no, name, year, dob, major, advisor, thesis);
    }
    //Bu methodların override edilmesine gerek yok yani override edilmeden de sınıf çalışabilir ve miras olarak
    //aldığı şekliyle yani bir üst sınıfta tanımlandığı şekliyle kullanmaya devam edebilir.
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
