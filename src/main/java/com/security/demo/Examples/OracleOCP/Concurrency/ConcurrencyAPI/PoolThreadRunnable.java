package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable {
    private Thread thread=null;
    private BlockingQueue<Runnable> taskQueue=null;
    private boolean isStopped=false;

    public PoolThreadRunnable(BlockingQueue queue){
        taskQueue=queue;
        //System.out.println(taskQueue);
    }

    public void run(){
        this.thread=Thread.currentThread();
        while(!isStopped){
            //yaratılan thread durdurulana kadar çalışmaya devam ediyor taskQueue dan bir task çekiyor ve çalıştırıyor
            try{
                Runnable runnable=(Runnable) taskQueue.take();
                //System.out.println(runnable.toString());
                runnable.run();
            }catch (Exception e){
                //System.out.println(e.getMessage());
            }
        }
    }

    public synchronized void doStop(){
        isStopped=true;
        this.thread.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
