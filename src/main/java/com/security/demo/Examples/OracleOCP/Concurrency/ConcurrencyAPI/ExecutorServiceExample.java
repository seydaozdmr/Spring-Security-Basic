package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(10);
        //10 thread'in aynı anda çalıştığı bir ThreadPool yaratı ve kendisine gelen görevleri aynı anda gerçekleştirir.
        service.execute(()-> System.out.println(Thread.currentThread().getName()+" task-1"));
        service.execute(()-> System.out.println(Thread.currentThread().getName()+" task-2"));
        service.execute(()-> System.out.println(Thread.currentThread().getName()+" task-3"));
        service.execute(new ExampleRunnable());

        for(int i=0;i<16;i++){
            int taskNo=i;
            Runnable task=() -> System.out.println(Thread.currentThread().getName()+" task - "+taskNo);
            service.execute(task);
        }

        service.shutdown();


    }
    static class ExampleRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" task");
        }
    }
}
