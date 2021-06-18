package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class SeriToplama {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("x değeri:");
        int x=scanner.nextInt();

        System.out.println("n değeri: ");
        int n=scanner.nextInt();

        double toplam=0;
        int fak=1;

        for(int i=0;i<n;i++){
            toplam=(Math.pow(x,i))/(fak=fak*(1+i));
        }

        System.out.println(toplam);

    }
}
