package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    private BlockingQueue<Runnable> taskQueue=null;
    private List<PoolThreadRunnable> runnables=new ArrayList<>();
    private boolean isStopped=false;

    public ThreadPool(int numberOfThreads, int maxNumberOfTasks){
        taskQueue=new ArrayBlockingQueue(maxNumberOfTasks);

        for(int i=0;i<numberOfThreads;i++){
            PoolThreadRunnable poolThreadRunnable= new PoolThreadRunnable(taskQueue);
            //burada threadler yaratılıyor.
            runnables.add( poolThreadRunnable);
        }

        for(PoolThreadRunnable r:runnables){
            new Thread(r).start();
            //System.out.println("constructor çalışıyor");
        }
    }

    public synchronized void execute(Runnable task) throws Exception{
        if(this.isStopped){
            throw new IllegalStateException("Thread pool is stopped");
        }

        this.taskQueue.offer(task);
    }

    public synchronized void stop(){
        this.isStopped=true;
        for(PoolThreadRunnable runnable : runnables){
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished(){
        while(this.taskQueue.size()>0){
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                System.out.println("sdsad");
                e.printStackTrace();
            }
        }
    }

}
