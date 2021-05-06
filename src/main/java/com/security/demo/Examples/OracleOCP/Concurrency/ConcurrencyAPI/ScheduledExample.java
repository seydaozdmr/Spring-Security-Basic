package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExample {
    public static void main(String[] args) {
        ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
        System.out.println("scheduled task started: ");
        service.schedule(()-> System.out.println(Thread.currentThread().getName()+" : task-1"),3000, TimeUnit.MILLISECONDS);


        service.scheduleWithFixedDelay(()-> System.out.println(Thread.currentThread().getName()+ ": started"),2000,1000,TimeUnit.MILLISECONDS);


    }
}
