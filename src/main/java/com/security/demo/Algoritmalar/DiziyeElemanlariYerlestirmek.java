package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class DiziyeElemanlariYerlestirmek {
    //klavyeden girilen sayıları bir dizinin 1. ve n. sıradaki elemanlarına baştan ve sondan
    //ekleyen algoritma
    public static void main(String[] args) {
        int [] dizi=new int[10];
        Scanner scanner=new Scanner(System.in);
        int last=dizi.length-1;
        int start=0;
        for(int i=0;i<dizi.length;i++){
            System.out.println((i+1)+" . sayıyı giriniz: ");
            int j=scanner.nextInt();
            if(i%2==0){
                dizi[start]=j;
                start++;
            }else{
                dizi[last]=j;
                last--;
            }
        }
        for(int i:dizi){
            System.out.println(i);
        }
    }
}
