package com.security.demo.Examples.Siniflar.AbstractStudent;

public class RegistrationOffice {

    public Student getAStudent()
        {
            return new Student() {
                @Override
                public void study() {

                }

                @Override
                public void register() {

                }
            };
    }

    public void registerStudent(Student student){
        Student student1=student;
    }
}
