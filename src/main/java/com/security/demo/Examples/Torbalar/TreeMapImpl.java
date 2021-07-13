package com.security.demo.Examples.Torbalar;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapImpl {
    public static void main(String[] args) {
        Map<String,Integer> illerUzaklık=new TreeMap<>();
        illerUzaklık.put("İstanbul" , 612);
        illerUzaklık.put("Antalya",80);
        illerUzaklık.put("Ankara", 466);
        illerUzaklık.put("Kilis",903);
        illerUzaklık.put("Hakkari",1616);

        for(Map.Entry<String,Integer> i:illerUzaklık.entrySet()){
            System.out.println("il: "+i.getKey()+" - "+i.getValue());
        }

        Map<String,Integer> test=(NavigableMap) illerUzaklık;

    }
}
