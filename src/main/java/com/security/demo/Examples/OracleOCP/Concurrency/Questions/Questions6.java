package com.security.demo.Examples.OracleOCP.Concurrency.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Questions6 {
    static int count=0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service=null;
        try{
            service= Executors.newSingleThreadExecutor();
            List<Future<?>> list=new ArrayList<>();
            ExecutorService finalService = service;
            IntStream.iterate(0, i->i+1).limit(5)
                    .forEach(i->list.add(finalService.submit(()->{count++;})));
            for(Future<?> result:list){
                System.out.println(result.get()+" ");
            }
        }finally {
            if(service!=null) service.shutdown();
        }
    }
}
