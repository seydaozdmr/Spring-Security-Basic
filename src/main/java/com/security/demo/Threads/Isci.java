package com.security.demo.Threads;

public class Isci {
    public static void main(String[] args) throws InterruptedException {
        Calisan calisan=new Calisan();
        calisan.setName("Bekleme Thread'i");
        calisan.start();
        for(int i=0;i<10;i++){
            System.out.println(i+" Thread: "+Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
class Calisan extends Thread{
    public void run(){
        try{
            System.out.println("Çalışan çalışmaya başladı Thread:"+currentThread().getName());
            Thread.sleep(10000);
            System.out.println("Çalışan işlemini bitirdi.."+currentThread().getName());
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
