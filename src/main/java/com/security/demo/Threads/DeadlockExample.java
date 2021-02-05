package com.security.demo.Threads;

public class DeadlockExample {
    public static Object lock1=new Object();
    public static Object lock2=new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    public static class Thread1 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 1 has lock1");
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                System.out.println("Thread 1 waiting for lock2:");
                synchronized (lock2){
                    System.out.println("Thread 1 has lock1 and lock2");
//                    try{
//                        Thread.sleep(10000);
//                    }catch (InterruptedException e){
//                        System.out.println(e.getMessage());
//                    }
                }
                System.out.println("Thread 1 released lock2");
            }
            System.out.println("Thread 1 relased lock1");
        }
    }
    //Thread 2 yi bu şekilde kullanırsak deadlock meydana geliyor bunu önlemek için lock objelerimizi sırayla
    //synchronize ediyoruz..
//    public static class Thread2 extends Thread{
//        public void run(){
//            synchronized (lock2){
//                System.out.println("Thread 2 has lock2");
//                try{
//                    Thread.sleep(100);
//                }catch (InterruptedException e){
//                    System.out.println(e.getMessage());
//                }
//                System.out.println("Thread 2 waiting for lock1");
//                synchronized (lock1){
//                    System.out.println("Thread 2 has lock1 and lock2");
//                }
//                System.out.println("Thread 2 released lock1");
//            }
//            System.out.println("Thread 2 released lock2");
//        }
//    }
    public static class Thread2 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 2 has lock1");
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                System.out.println("Thread 2 waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread 2 has lock1 and lock2");
                }
                System.out.println("Thread 2 released lock2");
            }
            System.out.println("Thread 2 released lock1");
        }
    }
}
