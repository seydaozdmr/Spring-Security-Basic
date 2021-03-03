package com.security.demo.Examples.RasyonelSayilar;

import java.util.HashMap;
import java.util.Map;

public class Ekok {
    public static void main(String[] args) {
        System.out.println(ekok(3,4,5));
        System.out.println("-----------------");
        System.out.println(ekok(17,91));
        System.out.println("-----------------");
        System.out.println(ekok(6,4,5));
    }


    public static int ekok(Integer ... sayilar){
        int numberOfArguments=sayilar.length;
        int enBuyuk=0;
        Map<Integer,Integer> bolunenSayilar=new HashMap<>();

        for(int i=0;i<numberOfArguments;i++){
            if(sayilar[i]>enBuyuk){
                enBuyuk=sayilar[i];
            }
        }
        System.out.println("en büyük sayı: "+enBuyuk);
        int ekok=1;
            for(int j=0;j<numberOfArguments;j++){
                int tamBolen=1;
                int bolunenArguman=0;
                for(int i=2;i<=enBuyuk;i++){
                    if(sayilar[j]%i==0){
                        
                        bolunenArguman++;
                        tamBolen=i;
                        System.out.println(sayilar[j]+" tam bölen= "+tamBolen );
                        sayilar[j]/=i;
                        System.out.println("Bölüm sonrası değer "+sayilar[j]);

                        ekok*=tamBolen;
                        j=0;
                    }
                }
                //TODO bölümleri bir listeye kaydetip ortak katların en küçüklerini almalıyım
            }
        return ekok;
    }
}
