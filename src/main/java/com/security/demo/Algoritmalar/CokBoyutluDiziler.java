package com.security.demo.Algoritmalar;

public class CokBoyutluDiziler {
    public static void main(String[] args) {
        int [][] koordinatlar=new int[10][2];
        for(int i=0;i<koordinatlar.length;i++){
            koordinatlar[i][0]=(int)(Math.random()*100);
            koordinatlar[i][1]=(int)(Math.random()*100);
        }

        for(int[] i:koordinatlar ){
            System.out.println(i[0]+ " - - - "+i[1]);
        }

    }
}
