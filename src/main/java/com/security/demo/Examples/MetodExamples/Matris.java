package com.security.demo.Examples.MetodExamples;

import java.util.Random;

public class Matris {
    public static void main(String[] args) {
        int [][] dizi=generateMatris();
        caprazTopla(dizi);

    }

    private static int [][] generateMatris(){
        Random random=new Random();
        int[][] dizi=new int[5][5];
        for(int i=0;i< dizi.length;i++){
            for(int j=0;j<dizi[0].length;j++){
                dizi[i][j]=random.nextInt(9);
                System.out.print(dizi[i][j] + " ");
            }
            System.out.println();
        }
        return dizi;
    }

    private static int caprazTopla(int[][] dizi){
        int toplam=0;
        int k=dizi[0].length-1;
        for(int i=0;i< dizi.length;i++){
            for(int j=0;j<dizi[i].length;j++){
                if(i==j || j==(dizi[0].length-i-1)){
                    toplam+=dizi[i][j];
                    System.out.println(toplam);
                }
            }
//            for(int j=k;j>=0;j--){
//                toplam+=dizi[i][j]+dizi[i][i];
//                k--;
//                if(i==j){
//                    //eğer 2. satırın 2. sütununda isek 2 kez toplamış olacağız bunlardan birini siliyorum.
//                    toplam-=dizi[i][i];
//                }
//                System.out.println(toplam);
//                break;
//            }
        }
        return toplam;
    }

}
