package com.security.demo.Examples.OracleOCP.Concurrency;

public class ObjectMonitor {
    private Object monitor1= new Object();
    private Object monitor2=new Object();

    private int counter1=0;
    private int counter2=0;

    public void intCount() throws InterruptedException {
        synchronized (this.monitor1){
            counter1++;
            Thread.sleep(100);
        }
    }

    public void intCount2() throws InterruptedException {
        synchronized (this.monitor2){
            counter2++;
        }
    }

    public int getCounter1(){
        synchronized (this.monitor1){
            return counter1;
        }
    }

    public int getCounter2(){
        synchronized (this.monitor2){
            return counter2;
        }
    }
}
