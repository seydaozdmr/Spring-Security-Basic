package com.security.demo.Examples.OracleOCP.StreamsExample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExample2 {
    public static void main(String[] args) {
        List<Integer> listem=new ArrayList<>();
        listem.add(1);
        listem.add(5);
        listem.add(3);
        listem.add(2);
        listem.add(4);

        listem.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return -1;
                else if(o2>o1) return 1;
                else return 0;
            }
        }).forEach(System.out::println);
        System.out.println("*******************");
        List<Integer> listem2=new ArrayList<>();
        listem2.add(1);
        listem2.add(5);
        listem2.add(3);
        listem2.add(2);
        listem2.add(4);
        listem2.stream()
                .peek(System.out::print)
                //.filter(p->p>2)
                .limit(3)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        List<Ogrenci> ogrenciler=new ArrayList<>();
        ogrenciler.add(new Ogrenci(1,"Ali","Aslan"));
        ogrenciler.add(new Ogrenci(2,"Hasan","Akın"));
        ogrenciler.add(new Ogrenci(3,"Mehmet","Gök"));
        ogrenciler.add(new Ogrenci(4,"Yılmaz","Erdoğan"));

        ogrenciler.stream().forEach(System.out::println);

        Map<Integer,Ogrenci> myMap=ogrenciler
                .stream()
                .collect(Collectors.toMap(Ogrenci::getId, Function.identity()));
        System.out.println(myMap);

        myMap.forEach((p,v)-> System.out.println(p+" "+v));

        System.out.println(myMap.get(1));

//        for(Map.Entry i: myMap.entrySet()){
//            System.out.println(i+ " "+myMap.get(i));
//        }
    }

    static class Ogrenci{
        private int id;
        private String name;
        private String lastName;

        public Ogrenci(int id, String name,String lastName) {
            this.id = id;
            this.name = name;
            this.lastName=lastName;
        }

        public int getId() {
            return id;
        }


        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "Ogrenci{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
