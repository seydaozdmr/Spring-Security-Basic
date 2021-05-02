package com.security.demo.Examples.OracleOCP.Concurrency;

public class ThreadReferance {
    public static void main(String[] args) {
        Runnable r1=()->{
            String threadName=Thread.currentThread().getName();
            System.out.println("this thread's name : "+threadName);
        };

        r1.run();
        Thread t1=new Thread(r1);
        t1.start();
    }
}
