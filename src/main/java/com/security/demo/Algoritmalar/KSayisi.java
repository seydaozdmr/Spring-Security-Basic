package com.security.demo.Algoritmalar;

public class KSayisi {
    /**
     * Bir k sayısı tek ise 3 ile çarpılıp 1 ekleniyor, çift ise 2'ye bölünüyor
     * Bu işlem k 1 olarana kadar devam ediyor
     * 1- bu işlemin kaç adım sürdüğünü
     * 2- işlem sırasında k'nın aldığı max değeri
     * 3- k'nın hangi sayıdan sonra hep çift olarak 1'e ulaştığını bulan algoritma
     */

    public static void main(String[] args) {
        int k= (int) (Math.random()*1000);

        int max=0;
        int step=0;
        int last=0;
        while(k!=1){
            if(k>max){
                max=k;
            }
            if(k%2==0){
                if(last<k){
                    last=k;
                }
                k/=2;
                step++;
            }else if(k%2!=0){
                k*=3;
                k++;
                step++;
            }
        }

        System.out.println("adım : "+step + " son sayı : "+last);


    }
}
