package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class DizilerSekilBasma {
    public static void main(String[] args) {
        ortasiBosDikdortgenBas();
        yildizCiz();
    }

    public static void yildizCiz(){

        char[][] yildizlar=new char[11][21];
        int m=0;
        for(int i=21;i>0;i-=2){
            for(int j=0;j<21;j++){
                if(j<i/2){
                    yildizlar[i/2][j]=' ';
                    //System.out.print(" ");
                }else if(j>=i/2 && j<=(i/2)+m) {
                    yildizlar[i/2][j]='*';
                    //System.out.print("*");
                }else{
                    yildizlar[i/2][j]=' ';
                    //System.out.print(" ");
                }
            }
            m+=2;
            //System.out.println();
        }

        for(int i=10;i>=0;i--){
            for(int j=0;j<21;j++){
                System.out.print(yildizlar[i][j]);
            }
            System.out.println();
        }
    }

    public static void ortasiBosDikdortgenBas(){
        int uzunluk=0,yukseklik=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("uzunluk bilgisi : ");
        uzunluk=sc.nextInt();
        System.out.println("yukseklik bilgisi : ");
        yukseklik=sc.nextInt();

        char [][] dizi=new char[yukseklik][uzunluk];
        for(int i=0;i< dizi.length;i++){
            for (int j=0;j<dizi[0].length;j++){
                if(i==0 || i== dizi.length-1){
                    dizi[i][j]='*';
                }else if(j==0 || j== dizi[i].length-1){
                    dizi[i][0]='*';
                    dizi[i][dizi[i].length-1]='*';
                }else{
                    dizi[i][j]=' ';
                }
            }
        }

        for(char[] i:dizi){
            for(char j:i){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
