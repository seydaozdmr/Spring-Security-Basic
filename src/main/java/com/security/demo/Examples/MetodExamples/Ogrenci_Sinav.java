package com.security.demo.Examples.MetodExamples;

import java.util.Random;
import java.util.Scanner;

public class Ogrenci_Sinav {
    public static void main(String[] args) {
        Random r=new Random();
        Scanner s=new Scanner(System.in);
        System.out.println("Öğrenci Sayısını Giriniz: ");
        int ogrenciSayisi=s.nextInt();
        System.out.println("Soru Sayısını Giriniz: ");
        int soruSayisi=s.nextInt();

        String [] cevaplar={"A","B","C","D","E"};
        String [] cevapAnahtari=new String[soruSayisi];
        for(int i=0;i<soruSayisi;i++){
            cevapAnahtari[i]=cevaplar[r.nextInt(5)];
        }
        String [][] degerlendirme=new String[10][2];
        String[][] formlar=new String[ogrenciSayisi][soruSayisi];

        for(int i=0;i<ogrenciSayisi;i++){
            for(int j=0;j<soruSayisi;j++){
                formlar[i][j]=cevaplar[r.nextInt(5)];
                degerlendirme[i][0]=String.valueOf(i);
                if(formlar[i][j].equals(cevapAnahtari[j])){
                    if(degerlendirme[i][1]==null){
                        degerlendirme[i][1]=String.valueOf(1);
                    }else{
                        int dogru=Integer.parseInt(degerlendirme[i][1])+1;
                        degerlendirme[i][1]=String.valueOf(dogru);
                    }
                }
                System.out.print(formlar[i][j]);
            }
            System.out.println();
        }

        for(int i=0;i<degerlendirme.length;i++){
            System.out.println(degerlendirme[i][0]+". öğrencinin doğru sayısı : "+degerlendirme[i][1]);
        }
    }
}
