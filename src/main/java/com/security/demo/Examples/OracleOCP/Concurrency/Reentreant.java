package com.security.demo.Examples.OracleOCP.Concurrency;

public class Reentreant {
    private int count=0;

    public synchronized void inc(){
        this.count++;
    }

    public synchronized int incAndGet(){
        inc();
        return this.count;
    }

    public static void main(String[] args) {
       Reentreant r1=new Reentreant();
       Thread t1=new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println(r1.incAndGet());
           }
       });
       t1.start();
    }
}
