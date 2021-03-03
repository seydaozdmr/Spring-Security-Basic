package com.security.demo.Examples.MetodExamples;

import java.util.Random;

public class Method_1 {
    public static void main(String[] args) {
        int [] dizi=dizi();
        System.out.println("dizinin ortalaması: "+ortalama(dizi));
        ortalamaAltindaKalanlar(dizi);
    }

    public static int[] dizi(){
        Random random=new Random();
        int[] dizi=new int[100];
        for(int i=0;i<dizi.length;i++){
            dizi[i]=random.nextInt(10000);
        }
        return dizi;
    }

    public static int ortalama(int [] dizi){
        int toplam=0;

        for(int i=0;i<dizi.length;i++){
            toplam+=dizi[i];
        }
        return (int) toplam/100;
    }

    public static void ortalamaAltindaKalanlar(int [] dizi){
        int ortalama=ortalama(dizi);
        int sayac=0;
        for(int i=0;i<dizi.length;i++){
            if(dizi[i]<ortalama){
                System.out.println(dizi[i]);
                sayac++;
            }
        }
        System.out.println("ortalamanın altında bulunan değer sayısı: "+sayac);
    }
}
