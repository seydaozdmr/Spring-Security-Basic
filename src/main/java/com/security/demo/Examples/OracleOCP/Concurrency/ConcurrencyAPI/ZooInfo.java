package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.*;


public class ZooInfo {
    private static int count=0;
    public static void main(String[] args) throws Exception {
        ExecutorService executorService=null;

        Runnable task1=()->
                System.out.println("Printing zoo inventory");
        Runnable task2=()->{
            for(int i=0;i<3;i++){
                System.out.println("Printing record "+i);
            }
        };

        try{
            executorService= Executors.newSingleThreadExecutor(); //1 tane thread yaratır ve bu thread'le Runnable tasklar çalıştırılır.
            System.out.println("begin");
            executorService.execute(task1);
            executorService.execute(task2);
            executorService.execute(task1);
            Thread.sleep(100);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(executorService!=null) executorService.shutdown();
        }

        submitTask();

    }

    public static void submitTask() throws Exception{
        ExecutorService executorService=null;
        try{
            executorService=Executors.newSingleThreadExecutor();
            Future<?> result=executorService.submit(()->{
                for(int i=0;i<500;i++){
                    count++;
                }
            });

            result.get(100, TimeUnit.SECONDS);
            System.out.println("reached");
        }catch (TimeoutException e){
            System.out.println("Not reached int time");
        }finally {
            if(executorService!=null){
                executorService.shutdown();
            }
        }

    }
}
