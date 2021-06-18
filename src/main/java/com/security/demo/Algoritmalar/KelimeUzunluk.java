package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class KelimeUzunluk {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int length=0;
        System.out.println("bir kelime giriniz");

        String name=sc.nextLine();
        char [] dizi=new char[1024];

        for(int i=0;i<dizi.length;i++){
            try{
                dizi[i]=name.charAt(i);
                length++;
            }catch (StringIndexOutOfBoundsException e){
                break;
            }

        }
        System.out.println("girilen kelimenin uzunluğu : "+ length);






    }
}
