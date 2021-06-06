package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class UcgenDurum {
    public static void main(String[] args) {
        int a=0,b=0,c=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("üçgenin kenarlarını giriniz:");
        a=scanner.nextInt();
        b=scanner.nextInt();
        c=scanner.nextInt();

        if(a==b){
            if(b==c){
                System.out.println("eşkenar");
            }else{
                System.out.println("ikizkenar");
            }

        }else if(a==c){
            System.out.println("ikizkenar");
        }else{
            if(b==c){
                System.out.println("ikizkenar");
            }else {
                System.out.println("çeşitkenar");
            }
        }
    }
}
