package com.security.demo.Examples.OracleOCP.Concurrency;

public class ThreadLocalBasicExample {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal=new ThreadLocal<>();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("Local - 1");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String value=threadLocal.get();
                System.out.println(value);
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("Local - 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String value=threadLocal.get();
                System.out.println(value);

            }
        });

        t1.start();
        t2.start();
    }
}
