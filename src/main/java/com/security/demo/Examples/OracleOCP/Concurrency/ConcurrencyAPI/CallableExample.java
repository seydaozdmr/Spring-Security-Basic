package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService=null;
        try{
            executorService= Executors.newSingleThreadExecutor();
            //We use this example <T> Future<T> submit(Callable <T> task)
            Future<Integer> result=executorService.submit(()->{
                return 30+45;
            });
            System.out.println(result.get());
        }finally {
            if(executorService!=null){
                executorService.shutdown();
            }
        }
    }
}
