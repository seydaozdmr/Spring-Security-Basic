package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        //girilen kelimeyi tersten yazdıran algoritma
        Scanner scanner=new Scanner(System.in);
        System.out.println("Bir kelime giriniz : ");
        String kelime=scanner.nextLine();

        char [] dizi=kelime.toCharArray();

        StringBuilder stringBuilder=new StringBuilder();

        for(int i=kelime.length();i>0;i--){
            stringBuilder.append(dizi[i-1]);
        }

        System.out.println(stringBuilder.toString());

    }
}
