package com.security.demo.Examples.Siniflar.Factory;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Employee employee=new Employee(5,"Ali",10,"Developer");
        System.out.println(employee.calculateSalary());

        Employee employee1=new Director(1,"Yasin", 10 ,"Production","Production",1000);
        employee1.printInfo();


    }
}
