package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class ToplamBulma {
    public static void main(String[] args) {
        int toplam=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("bir sayı giriniz:");
        int sayi=scanner.nextInt();

        for(int i=0;i<sayi;i++){
            toplam+=i;
        }
        System.out.println("toplam : "+toplam);
    }
}
