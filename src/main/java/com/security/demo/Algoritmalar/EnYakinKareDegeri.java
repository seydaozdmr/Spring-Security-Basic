package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class EnYakinKareDegeri {
    public static void main(String[] args) {
        float sayi=0, a=0,b=0,i=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("bir sayı giriniz:");
        sayi=scanner.nextInt();
        while((i*i)<sayi){
            i++;
            a=i*i;
        }

        b=(i-1)*(i-1);
        System.out.println("a: "+a+" - b:"+b);
        System.out.println("sonuc : "+((i-1)+((sayi-b)/(a-sayi))));

    }
}
