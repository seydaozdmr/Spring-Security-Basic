package com.security.demo.Algoritmalar;

import java.util.Arrays;
import java.util.Scanner;

public class FindPrimes {
    public static void main(String[] args) {
        System.out.println("hangi sayıya kadar asalları bulmak istiyorsun");
        Scanner scanner=new Scanner(System.in);
        int sayi=scanner.nextInt();

        countNumberOfPrimesUpTo(sayi);
    }

    public static void countNumberOfPrimesUpTo(int sayi){
        long start=System.currentTimeMillis();
        boolean [] list=new boolean[sayi+1];
        Arrays.fill(list,true); //listeyi komple true ile dolduruyoruz. daha sonra içindeki asal olmayanları false diye işaretliyoruz

        int upperBound=(int) (Math.sqrt(sayi)+1);
        for(int i=2;i<=upperBound;i++){
            if(list[i]==true){
                for(int j=2;i*j<=sayi;j++){
                    list[i*j]=false;
                }
            }
        }
        int numberOfPrimes=0;
        for(boolean b:list){
            if(b)
                numberOfPrimes++;
        }
        long end=System.currentTimeMillis();
        long result=end-start;

        System.out.println(sayi+ " sayısına kadar "+ (numberOfPrimes-2)+ " adet asal sayı vardır");
        System.out.println("toplam hesaplama zamanı : "+result+ " ms.");

    }
}
