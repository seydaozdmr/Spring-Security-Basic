package com.security.demo.LambdaExamples;

import java.util.ArrayList;
import java.util.List;

public class Example_9 {
    //Pipelines and Streams
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
        list.add(ali);
        list.add(kemal);

        list.stream().filter(e->e.getAge()>24).forEach(e-> System.out.println(e.getName()));
        //ortalama yaş: - reduction operations
        double avarage=list.stream().filter(p->p.getAge()>24).mapToInt(Personel::getAge).average().getAsDouble();
        System.out.println("listenin ortalama yaşı : "+avarage);
        long count=list.stream().filter(personel -> personel.getAge()>25).mapToInt(Personel::getAge).count();
        System.out.println("25 yaşından büyük elemanların sayısı : "+count);

        int totalAge=list.stream().mapToInt(Personel::getAge).sum();
        System.out.println("toplam yaş: "+totalAge);

        Integer totalAgeReduce=list.stream().mapToInt(Personel::getAge).reduce(0,(a,b)->a+b);
        System.out.println(totalAgeReduce);





    }
}
