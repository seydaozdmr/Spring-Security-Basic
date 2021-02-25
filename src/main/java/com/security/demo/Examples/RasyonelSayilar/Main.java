package com.security.demo.Examples.RasyonelSayilar;

import javax.management.StandardEmitterMBean;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        RasyonelSayi r1=new RasyonelSayi(8,10);
        r1.yazdir();

        ArrayList<String> isimler=new ArrayList<>();
        isimler.add("Hakan");
        isimler.add("Hasan");
        isimler.add("Yıldırım");

        List<String> yeniIsimler=isimler.subList(1,3);
        System.out.println(yeniIsimler.getClass());

        String [] sehirler={"Adana","Antalya","Artvin"};
        List<String> sehirlerList= Arrays.asList(sehirler);

        System.out.println(sehirlerList.getClass());

        Iterator<String> iterator=sehirlerList.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("list iterator sondan başa");
        ListIterator<String> listIteratorSondan=sehirlerList.listIterator(sehirlerList.size());
        while (listIteratorSondan.hasPrevious()){
            System.out.println(listIteratorSondan.previous());
        }

        //Not Hashmap yalnızca anahtar değer ikilisi olarak saklamak için kullanılır.
        //Ekleme sırasını dikkate almaz.
        //Ekleme sırasına göre eklenmesini istiyorsanız LinkedHashMap
        //Eğer belirli bir kurala göre ekleme yapmak istiyorsak TreeMap
        //A-Z 1-9 şeklinde ya da Comparable implemantasyonu ile sınıf değerlerini sırasına göre ekleyebiliriz.
    }
}
