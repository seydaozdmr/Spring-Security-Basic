package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class BasamakKupleri {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean sayiGirildi=false;
        int sayi=0;
        while(!sayiGirildi){
            System.out.println("3 basamaklı bir sayı giriniz: ");
            sayi=scanner.nextInt();
            if(sayi>99 && sayi<1000){
                sayiGirildi=true;
            }
        }
        int sonuc=0;
        int kopya=sayi;
        while(sayi>0){
            int kalan=sayi%10;
            sonuc+=kalan*kalan*kalan;
            sayi/=10;
        }
        if(sonuc==kopya){
            System.out.println("basamaklarının küpleri toplamı sayıya eşittir");
        }else{
            System.out.println("sayıya eşit değildir.");
        }
    }
}
