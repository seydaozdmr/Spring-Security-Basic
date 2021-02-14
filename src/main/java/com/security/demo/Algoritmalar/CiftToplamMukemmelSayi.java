package com.security.demo.Algoritmalar;

public class CiftToplamMukemmelSayi {
    public static void main(String[] args) {
        int toplam=0;
        for(int i=2;i<100;i+=2){
            toplam+=i;
        }
        System.out.println("toplam :"+toplam);

        int sonuc=0;
        for(int i=1;i<toplam;i++){
            if(toplam%2==0){
                sonuc+=i;
            }
        }
        if(sonuc==toplam){
            System.out.println("toplam mükemmel sayıdır");
        }else{
            System.out.println("toplam mükemmel sayı değildir.");
        }
    }
}
