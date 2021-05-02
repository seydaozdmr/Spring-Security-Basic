package com.security.demo.Examples.OracleOCP.Concurrency;

public class StoppableRunnable implements Runnable {
    private boolean stopRequested = false;

    public synchronized void requestStop(){
        this.stopRequested=true;
    }
    public synchronized boolean isStopRequested(){
        return this.stopRequested;
    }
    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Stoppable Runnable running");
        while(!isStopRequested()){
            sleep(1000);
            System.out.println("***");
        }
        System.out.println("Stoppable Runnable stopped");
    }

    public static void main(String[] args) {
        StoppableRunnable sr=new StoppableRunnable();
        Thread t1=new Thread(sr,"Thread - 1");
        t1.start();

        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("requesting stop");
        sr.requestStop();
        System.out.println("stop requested");

    }
}
