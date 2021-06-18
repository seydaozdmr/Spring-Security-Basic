package com.security.demo.Examples.Siniflar.Factory;

public class Manager extends Employee{
    protected String departmentManaged;

    public static final int MANAGER_PAYMENT=5000;

    public Manager(int no, String name, int year, String department, String departmentManaged) {
        super(no, name, year, department);
        this.departmentManaged=departmentManaged;
        System.out.println("in Manager() constructor!");
    }

    protected String sayPayment(){
        return "Manager Payment is: "+ MANAGER_PAYMENT;
    }
}
