package com.security.demo.Examples.OracleOCP.Concurrency;

public class ChechResults {
    private static int counter=0;

    public static void main(String[] args) {
        new Thread(()->{
           for(int i=0;i<1_000_000;i++) ChechResults.counter++;
        }).start();
        while(ChechResults.counter<1_000_000){
            System.out.println("Not reached yet - "+ChechResults.counter);
        }
        System.out.println("reached!");
    }
}
