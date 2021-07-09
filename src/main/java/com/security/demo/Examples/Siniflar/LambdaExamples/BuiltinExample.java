package com.security.demo.Examples.Siniflar.LambdaExamples;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuiltinExample {
    public static void main(String[] args) {
        /**
         * Predicate
         * @param (String)
         * @return boolean
         * bir önermeyi test etmek için kullanıyoruz.
         * örneğin s String'i "s" harfiyle mi başlıyor
         *
         * aynı zamanda built-in functions lambda expression'ların hedef tipidir (target type)
         * değişken olarak atanıp tekrar tekrar kullanılabilirler.
         */
        Predicate<String> predicate=String::isEmpty;
        Predicate<String> predicate1=(s)->s.startsWith("s"); //lambda ifadesini kendine atıyor interface
        System.out.println(predicate.test(""));
        System.out.println(predicate1.test("seyda"));

        /**
         * Function
         * @param(String)
         * @return(Integer)
         * aldığı String tipindeki değişkenin eleman kaç elemandan oluştuğunu integer olarak döndüren metot
         */
        Function<String,Integer> function=(s)->s.length();
        System.out.println(function.apply("seyda"));
        Function<String,Boolean> function1=(s)->s.equals("asd");

        long start=System.currentTimeMillis();
        List<Integer> myList= Stream.of("seyda","hatice","furkan")
                .map(s->s.length())
                .collect(Collectors.toList());
        long end=System.currentTimeMillis();
        System.out.println("listesi "+(end-start)+" süresinde oluştu.");
        System.out.println(myList);

        //yukarıdaki stream ve lambda ifadelerini şu şekilde ifade edebilirdik.
        List<String> testList=new ArrayList<>();
        testList.add("seyda");
        testList.add("hüseyin");
        testList.add("carl");
        start=System.currentTimeMillis();
        List<Integer> result=countListElem(testList);
        end=System.currentTimeMillis();
        System.out.println("listesi "+(end-start)+" süresinde oluştu.");
        System.out.println(result);

        /**
         * BiFunction
         * @param(List<String>,Integer)
         * @return Integer
         * bir liste içinde r elemanlı isimlerden fazla olan kaç tane isim vardır
         */
        BiFunction<List<String>,Integer,Integer> biFunction=new BiFunction<List<String>, Integer, Integer>() {
            @Override
            public Integer apply(List<String> strings, Integer s) {
                int result=0;
                for(String i:strings){
                    if(i.length()>s){
                        result++;
                    }
                }
                return result;
            }
        };

        int countBigThan = biFunction.apply(testList,5);
        System.out.println(countBigThan);

        /**
         * Consumer
         * @param <T> t
         * void
         * bir tipten paramtre alır ve void olarak işler
         *
         */

        Consumer<String> myConsumer=s->System.out.println(s.length());
        myConsumer.accept("merhaba java dünyası");
        Consumer<String> convertToLowerCase= s->System.out.println(s.toLowerCase());
        convertToLowerCase.accept("ASSALFJLFjslafklfjalf");
        /**
         * BiConsumer
         * @param <T> t, <U> u
         *iki farklı tipi consume etmek için kullanıyoruz.
         * geriye değer döndürmüyor
         */

        BiConsumer<String,Integer> myBiConsumer=(s1,u1)->System.out.println(s1 +" " +String.valueOf(u1));
        myBiConsumer.accept("derece : ",32);

        /**
         * Supplier
         * @return <T> t
         * bir tipten geriye değer döndürür
         * parametre almaz
         *kendi yarattığım illerList listesini supplier olarak daha sonra kullanabilirim
         * .get() methodu ile T tipinde geri değer döner
         */

        Supplier<List<String>> illerList=()->{
          List<String> liste=new ArrayList<>();
          liste.add("ankara");
          liste.add("istanbul");
          liste.add("antalya");
          return liste;
        };

        System.out.println(illerList.get());

        /**
         * BinaryOperator
         * @param <T> t <T> t
         * @return <T> t
         * aynı tipte iki parametre alıyor ve geriye aynı tipte dönüyor
         * BiFunction<T,T,T> extend ediyor
         */
        BinaryOperator<Integer> operator= (a,b) -> a%b;

        Comparator<Integer> comparator=(a,b)->a-b;
        BinaryOperator<Integer> operator1= BinaryOperator.maxBy(comparator);
        System.out.println(operator1.apply(10,18));

    }
    static List<Integer> countListElem(List<String> liste){
        List<Integer> result=new ArrayList<>();
        for(String i:liste){
            result.add(i.length());
        }
        return result;
    }
}
