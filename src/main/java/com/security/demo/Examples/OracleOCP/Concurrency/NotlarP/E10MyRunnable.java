package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E10MyRunnable {
    public static void main(String[] args) {

        MyRunnable myRunnable1=new MyRunnable();
        MyRunnable myRunnable2=new MyRunnable();

        Thread thread1=new Thread(myRunnable1,"Thread -1 ");
        Thread thread2=new Thread(myRunnable2,"Thread -2");
        thread1.start();
        thread2.start();

    }
}

class MyRunnable implements Runnable{
    private int count = 0;
    @Override
    public void run() {
        for(int i=0;i<1_000_000;i++){
            this.count++;
        }
        System.out.println(Thread.currentThread().getName() + " : "+this.count);
    }
}
