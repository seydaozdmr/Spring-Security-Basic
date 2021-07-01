package com.security.demo.Examples.Siniflar;

import java.util.ArrayList;
import java.util.List;

public class HesaplaTest {
    public static void main(String[] args) {
        //Not : java.lang paketinin tamamı otomatik olarak import edilir.

        double result = Math. pow(2,3);
        System.out.println(result);


        Hesapla hesapla=new Hesapla();

        int a=19;
        int b=100;

        int sonuc = hesapla.add(19  ,20);

        int x=-10;
        int y=-5;
        System.out.println(x>y);
        List<List<Integer>> liste=new ArrayList<>();
        for(int i=0;i<10;i++){
            liste.add(new ArrayList<>());
        }

    }
}
