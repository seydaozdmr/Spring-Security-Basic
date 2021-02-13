package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class Basamak {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Bir sayı giriniz: ");
        int sayi=scanner.nextInt();
        int basamak=0;
        while(sayi>0){
            sayi=sayi/10;
            basamak++;
        }
        System.out.println("Basamak: "+basamak);
    }
}
