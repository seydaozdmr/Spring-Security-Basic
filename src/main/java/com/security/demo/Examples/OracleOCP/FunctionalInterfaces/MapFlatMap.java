package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapFlatMap {
    public static void main(String[] args) {
        //The map() method create a one-to-one mapping from the elements in the stream to the elements of the
        //next step int the element

        //<R> Stream<R> map(Function <? super T,? extends R> mapper) method signature
        //how is it work?
        Stream<String> stream=Stream.of("ali","hasan","cem","yılmaz");
        //stream.map(String::length).forEach(System.out::println);
        //stream'deki elemanlar içindeki 3'den büyük ilk elemanı buluyor ve eğer varsa yazdırıyor.
        stream.map(p->p.length()).filter(p->p>3).findFirst().ifPresent(System.out::println);

        //flatMap() bir streamdeki elemanları alıyor her bir elemanı bir üst kademede birleştirip stream haline getiriyor
        //<R> Stream<R> flatMap(Function <? super T, ? extends Stream<? extends R>> mapper)

        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<String>();
        list2.add("ali");
        list2.add("veli");

        List<String> list3=new ArrayList<>();
        list3.add("hasan");
        list3.add("masam");
        list3.add("kamil");

        Stream<List<String>> s2=Stream.of(list1,list2,list3);

        s2.flatMap(m->m.stream()).forEach(System.out::println);


    }
}
