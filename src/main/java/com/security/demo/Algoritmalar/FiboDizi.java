package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class FiboDizi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Fibonachi dizisinin eleman sayısı :");
        int elem=sc.nextInt();
        int [] dizi=new int[elem];

        dizi[0]=1;
        dizi[1]=1;
        for(int i=2;i<dizi.length;i++){
            dizi[i]=dizi[i-1]+dizi[i-2];
        }

        for(int i:dizi){
            System.out.println(i);
        }

    }
}
