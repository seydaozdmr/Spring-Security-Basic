package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E16ExchangerExample {
    public static void main(String[] args) {
        SynchronizedExchanger synchronizedExchanger=new SynchronizedExchanger();

        Thread t1=new Thread(()->{
           for(int i=0;i<1000;i++){
               synchronizedExchanger.setObject(""+i);
           }
        });

        Thread t2=new Thread(()->{
           for(int i=0;i<1000;i++){
               System.out.println(synchronizedExchanger.getValue());
           }
        });

        t1.start();
        t2.start();
    }
}
