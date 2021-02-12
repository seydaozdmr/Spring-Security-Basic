package com.security.demo.Algoritmalar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KareToplami {
    public static void main(String[] args) {
        System.out.println("1. sayıyı giriniz: ");
        int x=sayiGir();
        System.out.println("2. sayıyı giriniz: ");
        int y=sayiGir();
        System.out.println("Kareleri toplam: "+((x*x)+(y*y)));
    }
    public static int sayiGir(){
        Scanner scanner=new Scanner(System.in);
        int a=0;
        try{
            a=scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        return a;
    }
}
