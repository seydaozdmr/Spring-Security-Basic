package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E3CreatingThread {
    public static void main(String[] args) {
        Runnable myRunnable=()-> System.out.println("hello world");

        Thread t1=new Thread(()-> System.out.println("hello world"));
        t1.start();
    }
}
