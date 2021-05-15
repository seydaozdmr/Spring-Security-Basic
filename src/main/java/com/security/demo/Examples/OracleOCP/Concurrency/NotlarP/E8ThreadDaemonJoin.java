package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E8ThreadDaemonJoin {
    public static void main(String[] args) {
        Runnable runnable=()->{
            while(true){
                sleep(1000);
                System.out.println("Running");
            }
        };
        //runnable sonsuz çalışsa bile daemon thread çalışan son thread ise işlemi sonlandırır.
        Thread thread=new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        //5 saniye sonra main thread sonlandırıldığında thread de sonlandırılır.
        //sleep(5000);

        //Join ise thread bitene kadar çalışmaya devam eder.
        try{
            //kendi oluşturduğumuz thread bitene kadar main thread'i bitirmez.
            thread.join();
        }catch (InterruptedException e){

        }
    }

    private static void sleep(int i) {
        try{
            Thread.sleep(i);
        }catch (InterruptedException e){

        }
    }
}
