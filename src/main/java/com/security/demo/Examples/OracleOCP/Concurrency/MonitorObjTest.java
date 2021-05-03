package com.security.demo.Examples.OracleOCP.Concurrency;

public class MonitorObjTest {
    public static void main(String[] args) throws InterruptedException {
        ObjectMonitor objectMonitor=new ObjectMonitor();
        Thread t1=new Thread(()->{
            for(int i=0;i<100;i++){
                try {
                    objectMonitor.intCount();
                    //Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(()->{
            for(int i=0;i<200;i++){
                try {
                    objectMonitor.intCount2();
                    //Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3=new Thread(()->{
            for(int i=0;i<98;i++){
                System.out.println(objectMonitor.getCounter1());
            }
        });

        Thread t4=new Thread(()->{
            for(int i=0;i<155;i++){
                System.out.println(objectMonitor.getCounter2());
            }
        });

        t1.start();
        //t2.start();
        t3.start();
        //t4.start();

    }
}
