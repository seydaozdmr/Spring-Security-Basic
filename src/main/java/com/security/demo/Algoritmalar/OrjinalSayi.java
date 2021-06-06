package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class OrjinalSayi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Bir sayı giriniz");
        int sayi=scanner.nextInt();

        if(isOriginal(sayi)){
            System.out.println("orjinal sayı");
        }else{
            System.out.println("orjinal değil");
        }

        for(int i=1000;i<9999;i++){
            if(isOriginal(i)){
                System.out.println(i+" orjinal sayıdır.");
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }


        }

    }

    private static boolean isOriginal(int sayi) {
        int toplam=0;
        int temp=sayi%100;
        toplam+=temp;
        sayi/=100;
        toplam+=sayi;
        if(sayi==(toplam^2)){
            return true;
        }else{
            return false;
        }
    }
}
