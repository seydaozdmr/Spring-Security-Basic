package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    private void removeLions() {
        System.out.println("Removing lions");
    }
    private void cleanPen() {
        System.out.println("Cleaning Pens!");
    }
    private void addLions() {
        System.out.println("Adding lions!");
    }
    public void performTask(){
        removeLions();
        cleanPen();
        addLions();
    }
    public void performTask(CyclicBarrier c1,CyclicBarrier c2){
        try{
            removeLions();
            c1.await();
            cleanPen();
            c2.await();
            addLions();
        }catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExecutorService service=null;
        try{
            service= Executors.newFixedThreadPool(4);
            CyclicBarrierExample example=new CyclicBarrierExample();
            CyclicBarrier c1=new CyclicBarrier(4);
            CyclicBarrier c2=new CyclicBarrier(4 , ()-> System.out.println("***pen cleaned"));
            for(int i=0;i<4;i++){
                service.submit(()->example.performTask(c1,c2));
            }
        }finally {
            if(service!=null) service.shutdown();
        }
    }

}
