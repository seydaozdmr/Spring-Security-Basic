package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service= Executors.newSingleThreadExecutor();

        Future future=service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" - task -1");
            }
        });

        Future future1=service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return 100;
            }
        });

        System.out.println(future.isDone());

        future.get();
        System.out.println(future1.get());

        System.out.println(future.isDone());
        service.shutdown();

    }
}
