package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class AsalMi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("bir sayı giriniz:");
        int i=scanner.nextInt();

        asalMi(i);

    }

    public static void asalMi(int sayi){
        int sayac=0;
        for(int i=2;i<sayi;i++){
            if(isAsal(i)){
                System.out.println(i+" asaldir.");
                sayac++;
            }else{
                //System.out.println(i +" asal değildir.");
            }
        }
        System.out.println("1 ile "+sayi+" arasında "+sayac+" kadar asal sayı vardır...");
    }

    public static boolean isAsal(int sayi){
        for(int i=2;i<=Math.sqrt(sayi);i++){
            if(sayi%i==0){
                return false;
            }
        }
        return true;
    }
}
