package com.security.demo.Examples.OracleOCP.Singleton;

public class BillPughExample {
    //private constructor
    private BillPughExample(){

    }

    public static BillPughExample getInstance(){
        return SingletonExample.billPughExample;
    }

    //yardımcı sınıf içinde static instance oluşturuyor.
    private static class SingletonExample{
        private static BillPughExample billPughExample=new BillPughExample();
    }

    public void test(){
        System.out.println("mytest");
    }
}
