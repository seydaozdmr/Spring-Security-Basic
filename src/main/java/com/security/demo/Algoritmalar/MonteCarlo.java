package com.security.demo.Algoritmalar;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class MonteCarlo {
    public static void main(String[] args) {
        System.out.println("Nokta sayısı giriniz: ");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        double toplamDaireIci=0,x=0,y=0;

        for(int i=0;i<n;i++){
            x= Math.random();
            y= Math.random();
            if((x*x+y*y)<=1){
                toplamDaireIci++;
            }
        }
        System.out.println(4.0*(toplamDaireIci/n));
        String name;


        File file=new File("newFile.txt");

    }
}
