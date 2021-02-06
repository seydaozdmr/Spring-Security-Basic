package com.security.demo.Threads;

import java.util.Scanner;

public class DegerAlma {
    public static void main(String[] args) {
        System.out.println("Kullanıcıdan 8 tane sayı alan ve bunun karekökünü gösteren program..");
        Data d=new Data();
        DegerOku degerOku=new DegerOku(d);
        Faktoriyel f=new Faktoriyel(d);
        Karakok karakok=new Karakok(d);

        degerOku.start();
//        karakok.start();
        //f.start();
        //değer oku thread'i bitmeden toplamı ekrana yazdırmıyoruz bunun için thred'i join ile bekletiyoruz.
        try{
            degerOku.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("toplam:"+d.getI());



    }
}

class Karakok extends Thread{
    private Data d;

    public Karakok(Data d) {
        this.d = d;
    }

    public void run(){
        synchronized (d){
            System.out.println("Karakök: "+Math.sqrt(d.getI()));
        }
    }
}

class Faktoriyel extends Thread{
    private Data d;

    public Faktoriyel(Data d){
        this.d=d;
    }

    public void run(){
        synchronized (d){
            int toplam=1;
            for(int i=1;i<=d.getI();i++){
                toplam*=i;
            }
            System.out.println(d.getI()+" sayısının faktöriyeli: "+toplam);
        }
    }
}

class DegerOku extends Thread{
    private Data d;
    int a;
    public DegerOku(Data d){
        this.d=d;
    }
    public void run(){
        synchronized (d){
            for(int i=0;i<5;i++){
                System.out.println((i+1)+". sayıyı giriniz:");
                Scanner scanner=new Scanner(System.in);
                a+=scanner.nextInt();
            }
            System.out.println("toplam değer: "+a);
            d.setI(a);
        }
    }
}

class Data{
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
