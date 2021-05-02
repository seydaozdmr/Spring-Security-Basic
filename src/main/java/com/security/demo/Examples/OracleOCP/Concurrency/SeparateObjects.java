package com.security.demo.Examples.OracleOCP.Concurrency;

public class SeparateObjects {
    public static void main(String[] args) {
        MyRunnable r1=new MyRunnable();
        MyRunnable r2=new MyRunnable();

        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);

        t1.start();
        t2.start();
    }
}
