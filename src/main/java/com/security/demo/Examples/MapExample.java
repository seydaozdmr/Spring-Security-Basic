package com.security.demo.Examples;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        HashMap<Integer,String> plakalar=new HashMap<>();

        plakalar.put(1,"Adana");
        plakalar.put(7,"Antalya");
        plakalar.put(6,"Ankara");
        plakalar.put(9,"Aydın");
        plakalar.put(15,"Burdur");

        System.out.println(plakalar.get(6));
        System.out.println(plakalar.size());
        System.out.println(plakalar.containsValue("Aydın"));

        plakalar.forEach((n,i)-> System.out.println("Plaka :"+n+" - İl :"+i));
        System.out.println("----------------------");
        for(Integer i:plakalar.keySet()){
            System.out.println("Plaka: "+i+" il: "+plakalar.get(i));
        }
        System.out.println("**********************");
        for(Map.Entry<Integer,String> i:plakalar.entrySet()){
            System.out.println(i.getKey()+" -- "+i.getValue());
        }
    }
}
