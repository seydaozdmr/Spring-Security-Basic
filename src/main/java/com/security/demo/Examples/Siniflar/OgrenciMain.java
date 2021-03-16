package com.security.demo.Examples.Siniflar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class OgrenciMain {
    public static void main(String[] args) {
        Random r=new Random();
        Ogrenci [] ogrenciler =new Ogrenci[100];
        for(int i=0;i<100;i++){
            ogrenciler[i]=new Ogrenci(r.nextInt(500),r.nextInt(100));
        }

        Arrays.sort(ogrenciler, new Comparator<Ogrenci>() {
            @Override
            public int compare(Ogrenci o1, Ogrenci o2) {
                if(o1.getNot()>o2.getNot()){
                    return -1;
                }else if(o1.getNot()<o2.getNot()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        for(Ogrenci o:ogrenciler){
            System.out.println("id: "+o.getId()+" not: "+o.getNot());
        }
    }
}
