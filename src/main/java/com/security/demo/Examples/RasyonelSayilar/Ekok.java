package com.security.demo.Examples.RasyonelSayilar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ekok {
    public static void main(String[] args) {
//        System.out.println(ekok(3,4,5));
//        System.out.println("-----------------");
//        System.out.println(ekok(17,91));
//        System.out.println("-----------------");
//        System.out.println(ekok(6,4,5));
        Map<Integer,Integer> ekoklistesi=ekok(4,5,8);
        ekoklistesi.forEach((k,v)-> System.out.println("bölüm : "+k+ "kaç kez: "+v));
        int ekok=1;
        for(Map.Entry deger: ekoklistesi.entrySet()){
            ekok*=(Integer)deger.getKey()*(Integer)deger.getValue();
        }
        System.out.println("ekok : "+ekok);
    }


    public static Map<Integer,Integer> ekok(Integer ... sayilar){
        int numberOfArguments=sayilar.length;
        int enBuyuk=0;
        Map<Integer,Integer> bolunenSayilar=new HashMap<>();
        Map<Integer,Integer> ekokListesi=new HashMap<>();
        for(int i=0;i<numberOfArguments;i++){
            if(sayilar[i]>enBuyuk){
                enBuyuk=sayilar[i];
            }
        }
            for(int j=0;j<numberOfArguments;j++){
                for(int i=2;i<=enBuyuk;i++){
                    if(sayilar[j]%i==0){
                        System.out.println("sayi : "+sayilar[j]);
                        if(!bolunenSayilar.containsKey(i)){
                            bolunenSayilar.put(i,1);
                        }else{
                            bolunenSayilar.put(i,bolunenSayilar.get(i)+1);
                        }
                        sayilar[j]/=i;
                        System.out.println("sayi2 : "+sayilar[j]);
                        i=2;
                        j=0;
                    }
                }
                bolunenSayilar.forEach((k,v)-> System.out.println("bölen : "+k+ "bölüm : "+v));

                for(Map.Entry bolumDeger: bolunenSayilar.entrySet()){
                    if(!ekokListesi.containsKey(bolumDeger.getKey())){
                        ekokListesi.put((Integer)bolumDeger.getKey(),(Integer)bolumDeger.getValue());
                        System.out.println("bölüm : "+bolumDeger.getKey()+" kaç kez :"+bolumDeger.getValue());
                    }else{
                        if((Integer)bolumDeger.getValue()<=ekokListesi.get(bolumDeger.getKey())){
                            ekokListesi.put((Integer) bolumDeger.getKey(),(Integer) bolumDeger.getValue());
                            System.out.println("bölüm2 : "+bolumDeger.getKey()+" kaç kez2 :"+bolumDeger.getValue());
                        }else{
                            ekokListesi.put((Integer) bolumDeger.getKey(),(Integer) bolumDeger.getValue()+1);
                        }
                    }
                }
            }

        //bolunenSayilar.forEach((k,v)-> System.out.println("bölen: "+k+" kaç kez: "+v));
        return ekokListesi;
    }
}
