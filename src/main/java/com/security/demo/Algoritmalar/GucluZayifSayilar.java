package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class GucluZayifSayilar {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Bir sayı giriniz: ");
        int sayi=scanner.nextInt();
        int bolen=0;
        for(int i=1;i<sayi;i++){
            if(sayi%i==0){
                bolen+=i;
            }
        }
        if(bolen>sayi){
            System.out.println("güçlü sayı");
        }else{
            System.out.println("zayıf sayı");
        }
    }
}
