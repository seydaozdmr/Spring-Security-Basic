package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E4ThreadExample1 {
    public static void main(String[] args) {
        //4 adet thread: asynchronous
        System.out.println("başlangıç");
        new WriteSomeData().start();
        new Thread(new Count()).start();
        new WriteSomeData().start();
        System.out.println("bitiş");

    }
}

class WriteSomeData extends Thread{
    public void run(){
        System.out.println("Saymaya başlıyorum");
    }
}

class Count implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(i);
        }
    }
}
