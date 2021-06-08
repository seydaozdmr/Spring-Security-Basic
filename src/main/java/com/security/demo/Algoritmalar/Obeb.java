package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class Obeb {
    public static void main(String[] args) {
        int a=0,b=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("birinci sayı? ");
        a=scanner.nextInt();
        System.out.println("ikinci sayı? ");
        b=scanner.nextInt();

        System.out.println(findObeb(a,b));
        System.out.println("ekok: "+findOkek(a,b,findObeb(a,b)));
    }
    public static int findObeb(int a,int b){
        int obeb=0;
        int start=1;
        while(start<b){
            if(b%start==0 && a%start==0){
                obeb=start;
            }
            start++;
        }
        return obeb;
    }

    public static int findOkek(int a,int b,int obeb){
        return (a*b)/obeb;
    }
}
