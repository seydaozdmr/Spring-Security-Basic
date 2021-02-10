package com.security.demo.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EnhancementBank {
    public static void main(String[] args) throws InterruptedException {
        NewBankAccount a1=new NewBankAccount(1000,"123");
        NewBankAccount a2=new NewBankAccount(2000,"256");

        new Thread(new Transfer(a1,a2,250),"Transfer -1 ").start();
        new Thread(new Transfer(a2,a1,1200), "Transfer -2").start();

//        Thread.sleep(5000);
//        System.out.println("a1 balance:"+a1.getBalance());
//        System.out.println("a2 balance:"+a2.getBalance());
    }
}

class NewBankAccount{
    private double balance;
    private String accountNumber;
    private Lock lock=new ReentrantLock();

    public NewBankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public boolean withdraw(double amount){
        if(lock.tryLock()){
            try{
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                balance-=amount;
                System.out.format("%s : Withdraw %f\n",Thread.currentThread().getName(),amount);
                return true;
            }finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean deposit(double amount){
        if(lock.tryLock()){
            try{
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                balance+=amount;
                System.out.format("%s : Deposite %f\n",Thread.currentThread().getName(),amount);
                return true;
            }finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean transfer(NewBankAccount destinationAccount,double amount){
        if(withdraw(amount)){
            if(destinationAccount.deposit(amount));
            return true;
        }else{
            System.out.format("%s: destination account is busy Refunding money\n",Thread.currentThread().getName());
            deposit(amount);
        }
        return false;
    }

    public double getBalance(){
        return balance;
    }

}

class Transfer implements Runnable{
    private NewBankAccount sourceAccount;
    private NewBankAccount destinationAccount;
    private double amount;
    public Transfer(NewBankAccount sourceAccount,NewBankAccount destinationAccount,double amount) {
        this.destinationAccount=destinationAccount;
        this.sourceAccount = sourceAccount;
        this.amount=amount;
    }

    @Override
    public void run() {
        while(!sourceAccount.transfer(destinationAccount,amount))
            continue;
        System.out.printf("%s completed\n",Thread.currentThread().getName());


    }
}

