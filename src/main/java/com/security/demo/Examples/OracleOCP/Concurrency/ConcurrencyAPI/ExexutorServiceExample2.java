package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExexutorServiceExample2 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);

        List<Callable<String>> callableList=new ArrayList<>();
        callableList.add(newCallable("Task-1"));
        callableList.add(newCallable("Task-2"));
        callableList.add(newCallable("Task-3"));

        try{
            String result=(String) executorService.invokeAny(callableList);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try{
            List<Future<String>> results=executorService.invokeAll(callableList);
            for(Future future:results){
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();


    }

    private static Callable<String> newCallable(String s) {
        return new Callable() {
            @Override
            public Object call() throws Exception {
                return Thread.currentThread().getName() +" task :"+ s;
            }
        };
    }
}
