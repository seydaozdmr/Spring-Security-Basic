package com.security.demo.Examples.OracleOCP.Concurrency.Questions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Questions4 {
    //This will cause Deadlock.
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        ExecutorService service= Executors.newFixedThreadPool(2);

        Future f1= service.submit(()->{
           synchronized (o1){
               synchronized (o2){
                   System.out.println("Tortoise!");
               }
           }
        });

        Future f2 = service.submit(()->{
           synchronized (o2){
               synchronized (o1){
                   System.out.println("Hare");
               }
           }
        });

        System.out.println(f1.get());
        System.out.println(f2.get());
    }
}
