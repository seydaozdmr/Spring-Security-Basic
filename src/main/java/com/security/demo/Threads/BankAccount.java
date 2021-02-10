package com.security.demo.Threads;

import java.util.concurrent.TimeUnit;
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
        //Reentrantlock example which lock the precess
//        lock.lock();
//        try{
//            this.balance +=amount;
//        }finally {
//            lock.unlock();
//        }
        //try
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    balance+=amount;
                }finally {
                    lock.unlock();
                }
            }else{
                System.out.println("Couldn't get the lock");
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }


    }

    public void withdraw(double amount){
        //reentrant lock
//        lock.lock();
//        try{
//            this.balance-=amount;
//        }finally {
//            lock.unlock();
//        }
        //this status is local variable so allocated in stack, shortly thread - safe.
        boolean status=false;
        try{
            if(lock.tryLock(1000,TimeUnit.MILLISECONDS)){
                try{
                    balance-=amount;
                    status=true;
                }finally {
                    lock.unlock();
                }
            }else{
                System.out.println("Couldn't get the lock.");
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Transaction status : "+status);
    }

    public double getBalance(){
        return this.balance;
    }

}
