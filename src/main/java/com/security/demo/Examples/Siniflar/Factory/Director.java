package com.security.demo.Examples.Siniflar.Factory;

public class Director extends Manager{
    protected double bonus;

    public Director(int no, String name, int year, String department, String departmentManaged,double bonus) {
        super(no, name, year, department, departmentManaged);
        this.bonus=bonus;
        System.out.println("in Manager() constructor!");
    }

    public void sayManagerPayment(){
        System.out.println(this.sayPayment());
    }
}
