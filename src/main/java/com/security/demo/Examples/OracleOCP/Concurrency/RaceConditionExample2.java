package com.security.demo.Examples.OracleOCP.Concurrency;

public class RaceConditionExample2 {
    public static void main(String[] args) {
        Counter2 c1=new Counter2();
        Counter2 c2=new Counter2();

        Thread t1=new Thread(getRunnable(c1,c2,"Thread 1"));
        Thread t2=new Thread(getRunnable(c2,c1,"Thread 2"));

        t1.start();
        t2.start();


    }

    private static Runnable getRunnable(Counter2 counterA,Counter2 counterB,String thread){
        return ()->{
          for(int i=0;i<1_000_000;i++){
              counterA.incAndGet();
          }

            System.out.println(thread+ " final count : " + counterA.get());
            System.out.println(thread+ " final count : " + counterB.get());
        };
    }
}
