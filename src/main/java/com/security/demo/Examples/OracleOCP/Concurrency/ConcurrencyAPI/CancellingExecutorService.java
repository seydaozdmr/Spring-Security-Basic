package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.*;

public class CancellingExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        Future future=executorService.submit(newCallable("Task - 1"));

        System.out.println(future.isDone());

        boolean mayInterrupt=false;
        boolean wasCancelled=future.cancel(mayInterrupt);
        System.out.println(wasCancelled);
        try{
            String result=(String) future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }catch (CancellationException e){
            String msg="Cannot call Future.get() since task was cancelled";
            System.out.println(msg);
        }

        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
        executorService.shutdown();

    }

    private static Callable<String> newCallable(String s) {
        return new Callable() {
            @Override
            public Object call() throws Exception {
                return Thread.currentThread().getName()+" : "+s;
            }
        };
    }
}
