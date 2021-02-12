package com.security.demo.Algoritmalar;

public class SayilarinKupleri {
    public static void main(String[] args) {
        int toplam=0;
        for(int i=1;i<100;i++){
            toplam+=i*i*i;
            System.out.println(i+".toplam : "+toplam);
        }
        System.out.println("1 den 100 e kadar olan sayıların küplerinin toplamı: "+toplam);
    }
}
