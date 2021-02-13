package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class ModAlma {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.sayı: ");
        int a=scanner.nextInt();
        System.out.println("2. sayı: ");
        int b=scanner.nextInt();

        modAl(a,b);

        int kalan=0;
        if(a>b){
            int bolum=a/b;
            //System.out.println((int) bolum);
            if(!((bolum*b)==a)){
                kalan=a-(bolum*b);
            }
        }
        if(kalan>0){
            System.out.println(a+" mod "+b+ " = "+kalan);
        }else{
            System.out.println(a+" mod "+b+" = 0");
        }

    }
    //döngü ile bölme işlemini çıkarma olarak gerçekleştirdik. kalan mod sonucu gösteriyor.
    public static void modAl(int a,int b){
        int kalan=0;
        while(a>b){
            a-=b;
        }
        kalan=a;
        System.out.println("mod "+kalan);
    }
}
