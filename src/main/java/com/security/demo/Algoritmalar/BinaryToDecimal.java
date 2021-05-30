package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        String deger="";

        Scanner sc=new Scanner(System.in);
        System.out.println("İkilik sistemde bir sayı giriniz");
        deger=sc.nextLine();
        int cast=Integer.valueOf(deger);
        System.out.println(deger);

        System.out.println("sonuc : "+binaryToDecimal(cast));

    }

    public static int binaryToDecimal(int deger){
        int toplam=0;
        int basamak=0;
        int temp=0;
        while(deger>0){
            temp =deger%10;
            toplam+=temp*Math.pow(2,basamak);
            deger/=10;
            basamak++;
        }
        return toplam;
    }
}
