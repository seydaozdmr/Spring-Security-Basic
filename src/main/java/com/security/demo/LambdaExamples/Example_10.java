package com.security.demo.LambdaExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class Example_10 {
    //Reduce and accumulator
    /*
    *
    * The reduce operation always returns a new value.
    * However, the accumulator function also returns a new
    * value every time it processes an element of a stream.
    * Suppose that you want to reduce the elements of a stream
    * to a more complex object, such as a collection. This might
    * hinder the performance of your application. If your reduce
    * operation involves adding elements to a collection, then every
    * time your accumulator function processes an element, it creates
    * a new collection that includes the element, which is inefficient.
    * It would be more efficient for you to update an existing collection instead.
    * You can do this with the Stream.collect method, which the next section describes.
     */

    public static void main(String[] args) {
        Personel ali=new Personel("ali",23);
        Personel mehmet=new Personel("mehmet",54);
        Personel yasin=new Personel("yasin",32);
        Personel kemal =new Personel("kemal",55);


        List<Personel> list=new ArrayList<>();
        list.add(ali);
        list.add(kemal);
        list.add(yasin);
        list.add(mehmet);
        ali.setAge(44); //aynı olan elemanların yaşlarını değiştiriyorum...
        list.add(ali);
        kemal.setAge(90);
        list.add(kemal);

        Averager averager=list.stream()
                .filter(p -> p.getAge()>25)
                .map(Personel::getAge)
                .collect(Averager::new,Averager::accept,Averager::combine);

        System.out.println("ortalama yaş: "+averager.average());

        //collect ile personel isimlerini liste haline getirmek:
        List<String> namesOfPersonel=list.stream()
                .map(Personel::getName)
                .collect(Collectors.toList());
        //stream().forEach ile listede bulunan değerleri ekrana yazdırmak.
        namesOfPersonel.stream().forEach(p-> System.out.println(p));

        //Sınıflandırma amacıyla:
        //The keys' corresponding values are instances of List
        // that contain the stream elements that, when processed by the classification
        // function, correspond to the key value.

        Map<Integer,List<Personel>> siniflandirma=list.stream().collect(Collectors.groupingBy(Personel::getAge));
        System.out.println("sınıflandırma:");
        siniflandirma.forEach(((integer, personels) -> System.out.println(integer+":"+personels)));

        //Personelin yaşlarına göre yalnızca isimleri liste olarak sınıflandırmak için:

        Map<Integer,List<String>> siniflandirmaIsimleri=list.stream().collect(Collectors.groupingBy(Personel::getAge,Collectors.mapping(Personel::getName,Collectors.toList())));
        System.out.println("İsimlere göre sınıflandırma:");
        siniflandirmaIsimleri.forEach(((integer, strings) -> System.out.println("yaş: "+integer+" personeller: "+strings)));

        //Her bir elemandan kaç tane var?
        System.out.println("Yaşları toplamı");
        Map<Integer,Integer> elemanSayisi=list.stream().collect(Collectors.groupingBy(Personel::getAge,Collectors.reducing(0,Personel::getAge,Integer::sum)));
        elemanSayisi.forEach((integer, integer2) -> System.out.println("yaş : "+integer+" adet: "+integer2));
        System.out.println("Ortalama yaş");
        Map<Integer,Double> yasOrtalaması=list.stream().collect(Collectors.groupingBy(Personel::getAge,Collectors.averagingInt(Personel::getAge)));
        yasOrtalaması.forEach((integer, aDouble) -> System.out.println("yaş : "+integer+" ortalama : "+aDouble));


    }
}

class Averager implements IntConsumer{
    private int total=0;
    private int count=0;

    public double average(){
        return count > 0 ? ((double) total) / count : 0;
    }



    @Override
    public void accept(int value) {
        total+=value;
        count++;
    }

    public void combine(Averager another){
        total+=another.total;
        count+=another.count;
    }

    @Override
    public IntConsumer andThen(IntConsumer after) {
        return null;
    }
}
