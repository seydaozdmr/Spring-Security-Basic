package com.security.demo.Algoritmalar;

public class Kuvvet {
    public static void main(String[] args) {
        int sonuc=kuvvet(2,5);
        System.out.println(sonuc);
    }

    public static int kuvvet(int x,int y){
        int sonuc=1;
        while(y>0){
            sonuc*=x;
            y--;
        }
        return sonuc;
    }
}
