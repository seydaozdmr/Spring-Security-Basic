package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E13RaceCondition {
    public static void main(String[] args) {
        MyRunnable4 myRunnable4=new MyRunnable4();
        //MyRunnable4 myRunnable41=new MyRunnable4();

        Thread thread1=new Thread(myRunnable4,"Mythread - 1");
        Thread thread2=new Thread(myRunnable4, "Mythread - 2");

        thread1.start();
        thread2.start();
    }

}

class MyRunnable4 implements Runnable{
    private int count=0;

    @Override
    public void run() {

        for(int i=0;i<1_000_000;i++){
            count++;

        }
        System.out.println(Thread.currentThread().getName()+ " : " +count);

    }
}
