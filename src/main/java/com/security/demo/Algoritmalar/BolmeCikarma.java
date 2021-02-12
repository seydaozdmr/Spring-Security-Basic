package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class BolmeCikarma {
    //Bölme işlemini çıkarma kullanarak yapan programın algoritma ve akış diyagramını çiziniz:
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Birinci sayı: ");
        int sayi1=scanner.nextInt();
        System.out.println("İkinci sayı: ");
        int sayi2=scanner.nextInt();
        int sayac=0;
        while(sayi1>sayi2){
            sayi1-=sayi2;
            sayac++;
        }
        System.out.println("bölüm : "+sayac);
        if(sayi1>0){
            System.out.println("bölümden kalan= "+sayi1);
        }else{
            System.out.println("kalansız bölünmüştür");
        }


    }
}
