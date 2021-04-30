package com.security.demo.Examples.OracleOCP.Concurrency;

public class Test_2 {
    public static void main(String[] args) {
        Runnable r1=()->{ //void run();
            System.out.println("I am running in " +Thread.currentThread().getName());
        };

        Thread t1 = new Thread(r1);
        t1.setName("My thread");
        t1.run(); //runs in main thread
        new Thread(r1).start();
    }
}
