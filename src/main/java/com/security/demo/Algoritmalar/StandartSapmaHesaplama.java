package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class StandartSapmaHesaplama {
    //girilen 10 rakamın tutulduğu bir dizinin standart sapmasını hesaplama
    public static void main(String[] args) {
        int [] dizi=new int[6];
        Scanner scanner=new Scanner(System.in);
        generate(dizi,scanner);
        double avarage=calculateAvarage(dizi);
        double varyans=calculateVaryans(dizi,avarage);


        double standartSapma=Math.sqrt(varyans);
        System.out.println("dizinin standart sapması : "+standartSapma);

    }

    private static double calculateVaryans(int[] dizi, double avarage) {
        double result=0.0;
        for(int i:dizi){
            result+=Math.pow((i-avarage),2);
        }
        return result/(dizi.length-1);
    }

    private static double calculateAvarage(int[] dizi) {
        int toplam=0;
        for(int i=0;i<dizi.length;i++){
            toplam+=dizi[i];
        }
        System.out.println("ortalama "+toplam/dizi.length);
        return toplam/dizi.length;
    }

    private static void generate(int[] dizi, Scanner scanner) {
        for(int i=0;i<dizi.length;i++){
            System.out.println((i+1)+" . değeri giriniz : ");
            dizi[i]=scanner.nextInt();
        }
    }
}
