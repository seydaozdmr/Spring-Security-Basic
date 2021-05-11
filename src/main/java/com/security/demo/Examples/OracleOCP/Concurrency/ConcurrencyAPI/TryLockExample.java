package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        new Thread(()-> printMessage(lock)).start();

        //Thread.sleep(1_000);
        if(lock.tryLock(5, TimeUnit.SECONDS)){
            try {
                Thread.sleep(1000);
                System.out.println("lock obtained , entering protected code");
            }catch (InterruptedException e){

            }finally {
                lock.unlock();
            }
        }else{
            System.out.println("unable to acquire lock, doing something else");
        }
    }

    public static void printMessage(Lock lock){
        try{
            lock.lock();
            System.out.println("print message method has lock");
        }finally {
            lock.unlock();
        }
    }
}
