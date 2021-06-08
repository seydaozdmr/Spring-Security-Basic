package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class EnBuyukRakam {
    //girilen bir sayının rakamları içindeki en büyük değeri bulmak
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("bir sayı giriniz: ");
        int sayi=scanner.nextInt();
        int enBuyuk=0;
        while(sayi>0){
            if(sayi%10>enBuyuk){
                enBuyuk=sayi%10;
            }
            sayi/=10;
        }

        System.out.println("en büyük rakam : "+enBuyuk);
    }
}
