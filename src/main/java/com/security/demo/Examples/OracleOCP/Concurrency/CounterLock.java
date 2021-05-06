package com.security.demo.Examples.OracleOCP.Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {
    private long count=0;
    private Lock lock=new ReentrantLock();

    public void inc(){
        try{
            lock.lock();
            count++;
        }finally {
            lock.unlock();
        }
    }

    public long getCount(){
        try{
            lock.lock();
            return count;
        }finally {
            lock.unlock();
        }
    }
}
