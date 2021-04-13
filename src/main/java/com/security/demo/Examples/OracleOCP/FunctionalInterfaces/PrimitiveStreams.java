package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        IntStream intStream= IntStream.of(1,2,3,4,5,6,7);
        OptionalDouble avarage=intStream.average();
        System.out.println(avarage.getAsDouble());


        IntStream intStream2= IntStream.of(1,2,3,4,5,6,7);
        Stream<Integer> box=intStream2.boxed();
        box.filter(p->p>4).forEach(System.out::println);

        DoubleStream randomDouble= DoubleStream.generate(Math::random);
        OptionalDouble average2=randomDouble.limit(10).peek(System.out::println).average();
        System.out.println(average2.getAsDouble());

        IntStream range=IntStream.range(1,10);
        range.forEach(System.out::println);

        DoubleStream d1=DoubleStream.of(1.2,2.3,4.5,6.5,3.8);
//        DoubleToIntFunction f1=new DoubleToIntFunction() {
//            @Override
//            public int applyAsInt(double value) {
//                return (int)value;
//            }
//        };
        IntStream i2=d1.mapToInt(x->(int)x);
        i2.forEach(System.out::println);

        LongStream longStream=LongStream.of(5,10);
        Long sum=longStream.sum();
        System.out.println(sum);

        DoubleStream doubleStream=DoubleStream.generate(()->Math.PI);
        OptionalDouble d=doubleStream.limit(1).min();
        System.out.println(d.getAsDouble());

        //min değeri fonksiyon yardımıyla bulabiliriz:
        IntStream stream=IntStream.iterate(10,x->x+2);
        System.out.println(min(stream.limit(10)));


        //Burada todoublefunction ile function fonksiyonu gibi T tipindeki veriyi double tipine dönüştürüyoruz.
        ToDoubleFunction<Integer> func=p->p.doubleValue();
        List<Integer> liste=new ArrayList<>();
        liste.add(1);
        liste.add(2);
        liste.add(3);
        liste.stream().mapToDouble(func).forEach(System.out::println);
    }
    private static int min(IntStream ints){
        OptionalInt optionalInt=ints.min();
        //eğer min değeri yoksa runtimeexception thrown ediyor.
        return optionalInt.orElseThrow(RuntimeException::new);
    }


}
