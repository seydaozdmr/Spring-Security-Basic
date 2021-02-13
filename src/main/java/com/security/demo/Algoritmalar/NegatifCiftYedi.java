package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class NegatifCiftYedi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int negatif=0;
        int cift=1;
        int yedi=0;
        for(int i=0;i<25;i++){
            System.out.println("Bir sayı giriniz: ");
            int sayi=scanner.nextInt();
            if(sayi<0){
                negatif+=sayi;
            }else if(sayi%2==0){
                cift*=sayi;
            }else if(sayi==7){
                yedi++;
            }
        }
        System.out.println("Negatif sayılar : "+negatif+" çift sayılar çarpımı: "+cift+" 7 sayısından : "+yedi+" adet");
    }
}
