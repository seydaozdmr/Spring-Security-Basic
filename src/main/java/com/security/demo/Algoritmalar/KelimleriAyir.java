package com.security.demo.Algoritmalar;

import java.util.StringTokenizer;

public class KelimleriAyir {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer=new StringTokenizer("seyda özdemir");
        while(stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }
    }
}
