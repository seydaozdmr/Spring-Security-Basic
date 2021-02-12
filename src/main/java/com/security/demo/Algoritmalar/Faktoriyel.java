package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class Faktoriyel {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Sayı giriniz: ");
        int sayi=scanner.nextInt();
        int toplam=1;
        for(int i=sayi;i>=1;i--){
            toplam*=i;
            System.out.println(i+".çarpım: "+toplam);
        }
        System.out.println(sayi+" sayısının faktöriyeli: "+toplam);

    }
}
