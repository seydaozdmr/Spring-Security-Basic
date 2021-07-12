package com.security.demo.Examples.Torbalar;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Start {
    public static void main(String[] args) {
        List<String> firstList=new ArrayList<>();
        firstList.add("ankara");
        firstList.add("istanbul");
        firstList.add("hakkari");

        Collections.sort(firstList,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Supplier<List<Integer>> supplier= ()-> new ArrayList<>();
        BiConsumer<List<Integer>,String> accumulator= (a,b)-> a.add(b.length());
        BiConsumer<List<Integer>,List<Integer>> combiner=(a,b) -> a.addAll(b);
        List<Integer> result=firstList.stream().collect(supplier,accumulator,combiner);
        System.out.println(result);

        //itreator çalışırken listenin elemanları değiştirilemez, eğer değiştirilirse hata fırlatır
        Iterator<String> iterator=firstList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //iterator yaparken silme işlemi gerçekleştirebiliriz.

        //iterable: (List iterable olduğu için list'i verebiliriz parametre olarak
        getList(firstList);

        //enhancement for
        forList(firstList);



    }
    static void getList(Iterable<String> iterableList){
        Iterator<String> iterator=iterableList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    static void forList(Iterable<String> iterable){
        iterable.forEach(System.out::println);
        //iterable.forEach((a)->System.out.println(a));
    }
}
