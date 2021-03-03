package com.security.demo.Examples.MetodExamples;

import java.util.Random;

public class Method_2 {
    //3*2 lik matris
    public static void main(String[] args) {
        int [] [] matris=new int[3][2];

        generateMatris(matris);
        matrisToplami(matris);
        enler(matris);


    }

    private static void enler(int[][] matris) {
        int enKucuk=matris[0][0];
        int enBuyuk=matris[0][0];
        for(int i=0;i<matris.length;i++){
            for(int j=0;j<matris[i].length;j++){
                if (matris[i][j]<enKucuk){
                    enKucuk=matris[i][j];
                }
                if(matris[i][j]>enBuyuk){
                    enBuyuk=matris[i][j];
                }
            }
        }
        System.out.println("matristeki en küçük değer : "+enKucuk);
        System.out.println("matristeki en büyük değer : "+enBuyuk);
    }

    private static void generateMatris(int[][] matris) {
        Random r=new Random();
        for(int i=0;i<matris.length;i++){
            for(int j=0;j<matris[i].length;j++){
                int a = matris[i][j]=r.nextInt(100);
                System.out.println((i+1)+". satır : "+(j+1)+" . sütun : "+a);
            }
        }
        //System.out.println(matris.length);
        //System.out.println(matris[0].length);
    }

    public static void matrisToplami(int [][] m){
        int toplam=0;
        int x=m.length;
        int y=m[0].length;

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                toplam+=m[i][j];
            }
        }
        System.out.println("Matris toplamı : "+toplam);
    }
}
