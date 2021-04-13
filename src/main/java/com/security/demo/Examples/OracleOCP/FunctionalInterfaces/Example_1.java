package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example_1 {
    public static void main(String[] args) {
        //ilk örnekte bir listeden ismi 4 karakter olan elemanları filtreleyip iki tanesini yazdırmaya çalışıyoruz
        List<String> liste=new ArrayList<>();
        liste.add("ali");
        liste.add("erkan");
        liste.add("emre");
        liste.add("ahmet");
        liste.add("musa");
        liste.add("kemallettin");
        liste.add("isa");
        liste.add("hami");

        List<String> filtered=new ArrayList<>();
        for(String i:liste) if(i.length()==4) filtered.add(i);
        Collections.sort(filtered);
        for(int i=0;i<2;i++){
            System.out.println(filtered.get(i));
        }

        //Bütün bu uğraş yerine:
        liste.stream()
                .filter(i->i.length()==4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);

//        Stream.generate(()->"Elsa")
//                .filter(n->n.length()==4)
//                .sorted() //burada sıralama hiç bir zaman bitmez bundan dolayı limit'e eleman gönderemez
//                .limit(2)
//                .forEach(System.out::println);

        Stream.generate(()->"Elsa")
                .filter(p->p.length()==4)  //eğer string değeri 4'den farklı olursa hiç bir zaman filter'dan true
                .limit(2)                   //eleman geçemez ve limit'e gelemez
                .sorted()
                .forEach(System.out::println);

        Long count=Stream.of("ali","veli","deli")
                .filter(p->p.length()>3)
                .collect(Collectors.toList())
                .stream()
                .count();
        System.out.println(count);

        Stream<Integer> s1=Stream.iterate(1,x->x+1);
        s1.limit(5).filter(x->x%2==1).forEach(System.out::println);
        Stream<Integer> s2=Stream.iterate(1,x->x+1);
        s2.limit(5).peek(System.out::println).filter(x->x%2==1).forEach(System.out::println);

        System.out.println("----------------");
        //Burada önemli olan chain'in hangi sıraya göre dizilecek olması
        Stream<Integer> s3=Stream.iterate(1,x->x+1);
        s3.filter(x->x%2==1).limit(5).forEach(System.out::println);
        //bu çıktıda önce filter çalışır filter'dan geçen elemanlardan 5 tanesini alırız.
        //yukarıda ise önce limit çalışıyordu limitten 5 eleman geçiyor geçen elemanlarda filter'dan
        //tekrar geçtikten sonra ekrana yazılıyorlardı.





    }
}
