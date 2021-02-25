package com.security.demo.Examples;

import java.util.*;

public class MapExample_2 {

    public static void main(String[] args) {
        //HashMap'de key değerinin HashCode 'u alınır ve buna karşılık bir index numarası belirlenir bu numaraya entry saklanır.
        //aynı HashCode'a sahip olan değerler aynı index içinde sırasıyla saklanır.
        HashMap<String,Integer> newMap=new HashMap<>();
        newMap.put("Ali",1);
        newMap.put("Fb",2);
        newMap.put(null,12354);
        newMap.put("elsa",3);
        newMap.put("fb",5);
        newMap.put("ea",5);

        LinkedHashMap<String,Integer> newMap2=new LinkedHashMap<>();
        newMap2.put("Ali",1);
        newMap2.put("Fb",2);
        newMap2.put(null,12354);
        newMap2.put("elsa",3);
        newMap2.put("fb",5);
        newMap2.put("ea",5);
        //LinkedHashMap'de ekleme sırama göre elemanları geri döndürüyor bunu yapmak için her bir elemandan önce header ve after değerlerini tutuyor bunlarla
        //önceki ve sonraki değerleri birbirine bağlıyor, entry'le (key,value)  farklı index numalarında saklanmalarına rağmen eklenme sıraları takip edilir.
        for(Map.Entry<String,Integer> e:newMap2.entrySet()){
            System.out.println(e.getKey()+" -- "+e.getValue());
        }


        TreeMap<String,Integer> newMap3=new TreeMap<>(new Comparator<String>() {  //Sınıf elemanlarını kıyaslarken Comparator anonim metodu sınıf içindeki Comparable'dan daha üstündür. Karşılaştırma yaparkan ilk önce bunu kullanır.
            @Override
            public int compare(String o1, String o2) {
                return o1.toUpperCase().compareTo(o2.toUpperCase());
            }
        });
        newMap3.put("Ali",1);
        newMap3.put("Fb",2);
        newMap3.put("elsa",3);
        newMap3.put("fb",5);
        newMap3.put("ea",5);
        System.out.println("----TreeMap----");
        newMap3.forEach((a,b)-> System.out.println("isim: "+ a+ " değer : "+b));
    }
}
