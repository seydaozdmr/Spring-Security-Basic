package com.security.demo.Algoritmalar;

import java.util.Arrays;

public class ArraysMethods {
    public static void main(String[] args) {
        int[] dizi={1,2,-13,55,3234,-56,123,-99};

        int[] copy= Arrays.copyOfRange(dizi,4,10); //kalan yerleri 0 ile doldurur.
        System.out.println(copy);
        for(int i:copy){
            System.out.println(i);
        }

        Arrays.sort(dizi);
        for(int i:dizi){
            System.out.print( i +" ");
        }

        System.out.println("--------------");
        int index=Arrays.binarySearch(dizi,55);
        System.out.println("55 : "+ index);
    }
}
