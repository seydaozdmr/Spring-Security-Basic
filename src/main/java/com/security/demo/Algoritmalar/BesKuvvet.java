package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class BesKuvvet {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Bir sayı giriniz: ");
        int sayi=scanner.nextInt();
        for(int i=1;i<10;i++){
            if(sayi==(Math.pow(5,i))){
                System.out.println(sayi+" sayısının 5'in "+i+". katıdır.");
                break;
            }
            if(sayi%(Math.pow(5,i))!=0){
                System.out.println(sayi+" sayısı 5'in kuvveti değildir.");
                break;
            }
//            if((sayi%(5^i))==0){
//                System.out.println(sayi+" sayisi 5'in "+i+". katıdır.");
//                break;
//            }
        }
    }
}
