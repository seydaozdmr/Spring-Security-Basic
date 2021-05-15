package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E6ThreadProperties {
    public static void main(String[] args) {
        //main thread
        String threadName=Thread.currentThread().getName();
        System.out.println(threadName);

        //current thread name
        Runnable runnable=()->{
            System.out.println(Thread.currentThread().getName()+" çalışıyor");
        };
        new Thread(runnable).start();

        //changing thread name
        Thread thread=new Thread(runnable);
        thread.setName("MyThread-1");
        thread.start();
    }
}
