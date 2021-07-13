package com.security.demo.Examples.Torbalar;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapImpl {
    public static void main(String[] args) {
//        Map<String,Integer> myMap=new HashMap<>();
//        Scanner scanner=new Scanner(System.in);
//        for(int i=0;i<5;i++){
//            System.out.println((i+1)+" . ismi giriniz");
//            String name=scanner.nextLine();
//
//            myMap.putIfAbsent(name,name.length());
//        }
//
//        System.out.println(myMap);

        Map<String,Integer> borcDefteri=new HashMap<>();
        borcDefteri.put("Hasan",50);
        /**
         * Merge
         * BiFunction ile önceki değerle yeni değeri birleştirip key e karşılık olarak atıyoruz
         */
        borcDefteri.merge("Hasan",100,(a,b)->a+b);
        System.out.println(borcDefteri);
        borcDefteri.put("ali",1500);
        borcDefteri.put("yılmaz",900);

        borcEkle(borcDefteri,"Hasan",1000);

        //you can obtain keySet or Values
        Set keys=borcDefteri.entrySet();

        Iterator<Map.Entry<String,Integer>> iterator=keys.iterator();

        while(iterator.hasNext()){
            //System.out.println(iterator.next());
            Map.Entry<String ,Integer> keySet=iterator.next();
            System.out.println("İsim : "+keySet.getKey()+ " - Borç : "+keySet.getValue());
        }

        Collection<Integer> values=borcDefteri.values();
        System.out.println(values.getClass());
        values.forEach(System.out::println);

        /**
         * Compute
         * Function ile computeIfAbsent metodunu çalıştırıp bir değer varsa değiştiriyoruz
         * yoksa ekliyoruz
         * computeIfPresent ise bir değer varsa değerin key ve value sunu alıp
         * BiFunction ile yeni bir değer üretiyoruz
         */

        BiFunction <String,Integer,Integer> borcSil=(k,v)-> v - 100;
        borcDefteri.compute("Hasan",borcSil);
        System.out.println(borcDefteri.get("Hasan"));
    }

    private static void borcEkle(Map<String, Integer> borcDefteri, String name, int miktar) {
        borcDefteri.merge(name,miktar,(a,b)->a+b);
    }
}
