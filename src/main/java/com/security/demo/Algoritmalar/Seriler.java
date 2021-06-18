package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class Seriler {
    public static void main(String[] args) {
        // 1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 ... serisinin toplamı

        Integer l=100;
        l=999;


        double toplam=1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Lütfen n giriniz : ");
        int n=scanner.nextInt();
        double divide=3;
        for(int i=1;i<n;i++){
            if(i%2==0){
                toplam=toplam + (1/divide);
                System.out.println("toplam : "+ toplam);
                divide+=2.0;
            }else{
                toplam= toplam - (1/divide);
                System.out.println("toplam : "+ toplam);
                divide+=2.0;
            }
        }

        System.out.println("sonuc : "+toplam );
    }
}
