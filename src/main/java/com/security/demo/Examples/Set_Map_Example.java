package com.security.demo.Examples;

import java.util.TreeMap;
import java.util.TreeSet;

public class Set_Map_Example {
    public static void main(String[] args) {
        TreeSet<String> treeSet=new TreeSet<>();
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        treeSet.add("4");
        treeSet.add("5");
        TreeMap<String,Integer> treeMap=new TreeMap<>();
        treeMap.put("1",1);
        treeMap.put("2",2);
        treeMap.put("3",3);
        treeMap.put("4",4);
        treeMap.put("5",5);
        System.out.println(treeSet.comparator());
        System.out.println(treeMap.comparator());

        TreeSet<String> yedekTreeSet= (TreeSet<String>) treeSet.subSet("2","4");
        //TreeMap<String,Integer> yedekMap= (TreeMap<String, Integer>) treeMap.subMap("2","4");

        yedekTreeSet.forEach(elem-> System.out.println(elem));
        //yedekMap.forEach(((s, integer) -> System.out.println(s+ " anahtarına karşılık gelen değer : "+integer)));
        System.out.println(treeMap.subMap("2","4"));

        System.out.println(treeSet.headSet("3"));
        System.out.println(treeMap.headMap("2"));

        System.out.println(treeSet.tailSet("4"));
        System.out.println(treeMap.tailMap("2"));

    }
}
