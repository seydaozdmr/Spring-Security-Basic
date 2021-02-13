package com.security.demo.Algoritmalar;

public class TamKare {
    public static void main(String[] args) {
        int tamKare=0;
        int i=4;
        while(tamKare<1000){
            if(tamKare>0)
                System.out.println(tamKare);
            tamKare=i*i;
            i++;

        }
    }
}
