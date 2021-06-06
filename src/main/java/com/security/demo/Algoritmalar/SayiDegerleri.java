package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class SayiDegerleri {
    //4 haneli bir tam sayının rakamları değerlerinin yazılması
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("4 basamaklı bir sayı giriniz");
        int sayi=scanner.nextInt();
        if(sayi>999 && sayi<10000){
            int temp=0;
            int sayac=1;
            while(sayi>0){
                temp=sayi%10;
                System.out.println(sayac+" lar basamağı : "+temp);
                sayi/=10;
                sayac*=10;
            }
        }else{
            System.out.println("girilen sayı 4 basamaklı değildir.");
        }
    }
}
