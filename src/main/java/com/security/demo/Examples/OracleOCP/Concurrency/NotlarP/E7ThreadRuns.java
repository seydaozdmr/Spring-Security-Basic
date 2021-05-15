package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E7ThreadRuns {
    public static void main(String[] args) {
        //main thread sona erse bile thread çalışmaya devam eder.
        Runnable runnable=()->{
            while(true){
                sleep(1000);
                System.out.println("Running");
            }
        };

        Thread thread=new Thread(runnable);
        thread.start();
        sleep(3000);
    }

    private static void sleep(int i) {
        try{
            Thread.sleep(i);
        }catch (InterruptedException e){

        }
    }

}
