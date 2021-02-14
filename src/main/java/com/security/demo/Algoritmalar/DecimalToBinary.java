package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        //Girilen decimal bir sayıyı ikilik (binary) sayıya çeviren program:
        Scanner scanner=new Scanner(System.in);
        System.out.println("Lütfen bir sayı giriniz: ");
        int sayi=scanner.nextInt();
        String sonuc="";
        while(sayi>0){
            sonuc+=String.valueOf(sayi%2);
            sayi/=2;
        }
        String sonuc2="";
        for(int i=sonuc.length();i>0;i--){
            sonuc2+=sonuc.charAt(i-1);
        }
        System.out.println(sonuc2);

        decimalToBinary(20);
    }

    public static void decimalToBinary(int sayi){
        int sonuc=0;
        double sayac=0;
        while(sayi>0){
            sonuc+=sayi%2*Math.pow(10,sayac);
            sayi/=2;
            sayac++;
        }
        System.out.println(sonuc);
    }
}
