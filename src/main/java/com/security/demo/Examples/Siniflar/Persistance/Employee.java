package com.security.demo.Examples.Siniflar.Persistance;

public class Employee extends Entity{
    private String password;

    public Employee(long id, String name,String password) {
        super(id, name);
        this.password=password;
    }


    public void work(){
        System.out.println("Employee is working");
    }

    public void calculateSalary(){
        System.out.println("salary is : ...");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
