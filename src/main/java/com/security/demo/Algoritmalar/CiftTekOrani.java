package com.security.demo.Algoritmalar;


import java.util.Scanner;

public class CiftTekOrani {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int cift=0;
        int tek=0;
        for(int i=0;i<20;i++){
            int sayi=0;
            System.out.println((i+1)+".sayıyı giriniz: ");
            sayi=scanner.nextInt();
            if(sayi%2==0){
                cift+=sayi;
                System.out.println("girilen :"+sayi+" çift sayılara eklenmiştir.");
            }else{
                tek+=sayi;
                System.out.println("girilen "+sayi+ "tek sayılara eklenmiştir.");
            }
        }
        System.out.println("çift sayıların tek sayılara oranı : "+(cift/tek));
    }
}
