package com.security.demo.Examples.OracleOCP.Concurrency;

public class SharedObject {
    public static void main(String[] args) {
        MyRunnable r1=new MyRunnable();

        Thread t1=new Thread(r1,"Thread 1");
        Thread t2=new Thread(r1,"Thread 2");

        t1.start();
        t2.start();
    }
}
