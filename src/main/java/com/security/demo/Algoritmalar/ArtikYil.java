package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class ArtikYil {
    public static void main(String[] args) {
        int yil=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("lütfen yıl giriniz");
        yil=sc.nextInt();

        System.out.println("artık yıl mı : ?");
        if(isArtik(yil)){
            System.out.println("artık yıl");
        }else{
            System.out.println("artık yıl değildir.");
        }


    }

    public static boolean isArtik(int yil){
        if(yil%4==0){
            return true;
        }else{
            return false;
        }
    }
}
