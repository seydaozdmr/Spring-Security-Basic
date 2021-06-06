package com.security.demo.Algoritmalar;

import java.util.Random;
import java.util.Scanner;

public class SayiBulmaca {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int tutulan=random.nextInt(100);
        System.out.println(tutulan);
        int tahminSayisi=0;
        for(int i=0;i<10;i++){
            System.out.println("bir tahmin yapınız");
            int tahmin=scanner.nextInt();
            tahminSayisi++;
            if(tahmin==tutulan){
                System.out.println(tahminSayisi+". tahminde buldunuz. doğru tahmin tebrikler");
                break;
            }else if(tutulan>tahmin){
                System.out.println("daha yüksek bir sayı tahmin ediniz");
            }else if(tutulan<tahmin){
                System.out.println("daha düşük tahmin ediniz.");
            }
        }
    }
}
