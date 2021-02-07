package com.security.demo.Threads;

public class BankExample {
    public static void main(String[] args) throws InterruptedException {
        final BankAccount bankAccount=new BankAccount(1000,"151330-551");
        Ali ali=new Ali(bankAccount);
        Ayse ayse=new Ayse(bankAccount);

        ali.start();
        ayse.start();

        ali.join();
        ayse.join();
        System.out.println("Güncel hesap : "+bankAccount.getBalance());

    }
}

class Ali extends Thread{
    private BankAccount bankAccount;

    public Ali(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void run(){
        bankAccount.deposit(300);
        try {
            System.out.println("Ali işlem yaptı güncel hesap: "+bankAccount.getBalance());
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.withdraw(50);

    }
}
class Ayse extends Thread{
    private BankAccount bankAccount;

    public Ayse(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void run(){

            bankAccount.deposit(203);
        try {
            System.out.println("Ayşe işlem yaptı güncel hesap: "+bankAccount.getBalance());
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.withdraw(100);


    }
}

