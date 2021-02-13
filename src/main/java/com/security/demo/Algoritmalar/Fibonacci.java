package com.security.demo.Algoritmalar;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("*****FİBONACCİ*****");
        int a=1;
        int b=1;
        int c;
        for(int i=0;i<10;i++){
            c=a+b;
            System.out.println((i+1)+". terim :"+c);
            a=b;
            b=c;
        }
    }
}
