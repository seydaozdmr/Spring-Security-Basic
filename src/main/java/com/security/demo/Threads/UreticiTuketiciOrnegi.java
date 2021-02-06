package com.security.demo.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UreticiTuketiciOrnegi {
    public static void main(String[] args) {
        OrtakAlan ortakAlan=new OrtakAlan();
        Uretici2 uretici2=new Uretici2(ortakAlan,ThreadColor.ANSI_PURPLE);
        Tuketici2 tuketici2=new Tuketici2(ortakAlan,ThreadColor.ANSI_BLUE);

        uretici2.start();
        tuketici2.start();
    }
}

class Uretici2 extends Thread{
    private OrtakAlan ortakAlan;
    private String color;

    public Uretici2(OrtakAlan ortakAlan,String color) {
        this.ortakAlan = ortakAlan;
        this.color=color;
    }
    @Override
    public void run(){
        Random random=new Random();
        Kaynak kaynak=new Kaynak();
        for(int i=0;i<kaynak.getKaynak().size();i++){
            ortakAlan.veriYaz(Integer.valueOf(kaynak.getKaynak().get(i)));
            System.out.println(color+"Üretici thread ile yazılan veri: "+kaynak.getKaynak().get(i));
            try {
                sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Tuketici2 extends Thread{
    private OrtakAlan ortakAlan;
    private String color;
    public Tuketici2(OrtakAlan ortakAlan, String color) {
        this.ortakAlan = ortakAlan;
        this.color = color;
    }
    @Override
    public void run(){
        Random random=new Random();
        Kaynak kaynak=new Kaynak();
        for(int i=0;i<kaynak.getKaynak().size();i++){
            System.out.println(color+"Tüketici veriyi alıyor: "+ortakAlan.veriAl());
            try {
                sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OrtakAlan{
    private int deger;

    public int veriAl(){
        return deger;
    }
    public void veriYaz(int i){
        this.deger=i;
    }
}


class Kaynak{
    private List<String> kaynak;
    public Kaynak() {
        this.kaynak = generateListe();
    }
    private List<String> generateListe(){
        List<String> liste=new ArrayList<>();
        for(int i=0;i<20;i++){
            liste.add(String.valueOf(i));
        }
        return liste;
    }
    public List<String> getKaynak() {
        return kaynak;
    }
}
