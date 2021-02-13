package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class PozitifNegatifSifir {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Bir sayı giriniz: ");
        int x=scanner.nextInt();
        if(x>0){
            System.out.println("pozitif sayı");
        }else if(x<0){
            System.out.println("negatif sayı");
        }else{
            System.out.println("sayı sıfırdır.");
        }
    }
}
