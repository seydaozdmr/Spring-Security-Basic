package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class Carpanlar {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.sayıyı giriniz : ");
        int x=scanner.nextInt();
        System.out.println("2.sayıyı giriniz : ");
        int y=scanner.nextInt();

        int carpanX=0;
        int carpanY=0;

        for(int i=(x-1);i>=1;i--){
            if(x%i==0){
                carpanX+=i;
                System.out.println(i);
            }
        }
        for(int i=(y-1);i>=1;i--){
            if(y%i==0){
                carpanY+=i;
                System.out.println(i);
            }
        }
        if(carpanX==y && carpanY==x){
            System.out.println(x+"ile"+y+" dost sayılar.");
        }else{
            System.out.println("dost sayı değillerdir.");
        }
    }
}
