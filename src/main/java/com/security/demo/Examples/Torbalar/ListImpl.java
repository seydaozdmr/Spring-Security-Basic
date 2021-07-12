package com.security.demo.Examples.Torbalar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListImpl {
    public static void main(String[] args) {
        List<Integer> sayilar=new ArrayList<>();
        sayilar.add(5);
        sayilar.add(1);
        sayilar.add(100);
        sayilar.add(44);
        sayilar.add(100);

        sayilar.sort((a,b)->a.compareTo(b));
        System.out.println(sayilar);

        System.out.println("UnaryOperator<T>");
        sayilar.replaceAll( a -> a*5);
        System.out.println(sayilar);

        System.out.println("SubList");
        List<Integer> subList=sayilar.subList(0,2);
        System.out.println(subList);

        System.out.println("RemoveIf takes Predicate<T>");
        subList.removeIf(a->a>5);
        System.out.println(subList);

        Set<Integer> mySet=new HashSet<>(sayilar);

        System.out.println(mySet);
    }
}
