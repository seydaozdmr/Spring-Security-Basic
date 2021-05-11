package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public class Example_4 {
    public static void main(String[] args) {
        Consumer<Integer> func=item-> System.out.println(item*2);
        func.accept(100);

        Consumer<String[]> func2=item-> System.out.println(item.length);
        String[]liste={"ali","hasan","mahmut"};
        func2.accept(liste);

        List<Integer> l1=new ArrayList<>();
        l1.add(3);
        l1.add(2);
        l1.add(1);
        l1.add(4);

        ObjDoubleConsumer<List<Integer>> func3=(list,num)->{
            list.stream()
                    .forEach(a-> System.out.println(a*num));
        };

        func3.accept(l1,2);


        List<insan> insans=new ArrayList<>();
        insans.add(new insan("Ali","Mali",12,Cinsiyet.MALE));
        insans.add(new insan("Hasan","Basri",25,Cinsiyet.MALE));
        insans.add(new insan("Mustafa","Kadir",20,Cinsiyet.MALE));
        insans.add(new insan("Hatice","Norcu",30,Cinsiyet.FEMALE));
        insans.add(new insan("Gülay","Norcu",50,Cinsiyet.FEMALE));
        insans.add(new insan("Hasan","Kaldırım",16,Cinsiyet.MALE));

        insans.stream().parallel()
                .forEachOrdered(p-> System.out.println(p.getName()));

        Supplier<Integer> supplier=()->(int) (Math.random()*100);

        System.out.println(supplier.get());





    }
}
