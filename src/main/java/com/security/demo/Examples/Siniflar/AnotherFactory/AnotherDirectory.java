package com.security.demo.Examples.Siniflar.AnotherFactory;

import com.security.demo.Examples.Siniflar.Factory.Manager;

public class AnotherDirectory extends Manager {
    public AnotherDirectory(int no, String name, int year, String department, String departmentManaged) {
        super(no, name, year, department, departmentManaged);
    }

    public void sayManagerPayment(){
        System.out.println(this.sayPayment());
        System.out.println(super.departmentManaged);
    }

    public void sayManagerPayment(Manager manager){
        //manager'ın üye değişkenlerine erişilemez
        //System.out.println(manager.departmentManaged);
    }
}
