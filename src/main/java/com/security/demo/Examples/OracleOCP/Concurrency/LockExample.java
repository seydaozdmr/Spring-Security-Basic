package com.security.demo.Examples.OracleOCP.Concurrency;

import java.util.Currency;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LockExample {
    public static void main(String[] args) {
        lockBasics();
    }

    private static void lockBasics(){
        ReentrantLock lock=new ReentrantLock(false);
        Runnable r1=()-> {
            try {
                lockSleepUnlock(lock, 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1=new Thread(r1,"Thread -1");
        Thread t2=new Thread(r1,"Thread -2");
        Thread t3=new Thread(r1,"Thread -3");
        t1.start();
        t2.start();
        t3.start();
    }

    private static void lockSleepUnlock(ReentrantLock lock, long i) throws InterruptedException {
        try{
            lock.lock();
            System.out.println("holds the lock "+ Thread.currentThread().getName());
            System.out.println("is locked? : "+lock.isLocked());
            sleep(i);
        }finally {
            lock.unlock();
        }
    }




}
