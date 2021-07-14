package com.security.demo.Examples.Torbalar;

import java.util.*;

public class ListImpl {
    public static void main(String[] args) {
        List<Integer> sayilar=new ArrayList<>();
        sayilar.add(5);
        sayilar.add(1);
        sayilar.add(100);
        sayilar.add(44);
        sayilar.add(100);

        System.out.println("****ForEachRemaining****");
        Iterator<Integer> iterator= sayilar.iterator();
        iterator.forEachRemaining(System.out::println);

        System.out.println("***ListIterator");
        ListIterator<Integer> listIterator=sayilar.listIterator();
        while(listIterator.hasNext()){
            int next=listIterator.next();
            System.out.println("next: "+next);
            if(next>40){
                listIterator.previous();
                System.out.println("prev: "+ listIterator.previous());
                break;
            }
        }

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
