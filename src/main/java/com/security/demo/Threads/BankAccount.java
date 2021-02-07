package com.security.demo.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock=new ReentrantLock();
    }

    public void deposit(double amount){
        lock.lock();
        try{
            this.balance +=amount;
        }finally {
            lock.unlock();
        }

    }

    public void withdraw(double amount){
        lock.lock();
        try{
            this.balance-=amount;
        }finally {
            lock.unlock();
        }

    }

    public double getBalance(){
        return this.balance;
    }

}
