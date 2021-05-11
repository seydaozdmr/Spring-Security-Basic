package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import net.bytebuddy.description.field.FieldDescription;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;

public class BuiltIn {
    public static void main(String[] args) {
        //Builtin Functional Interfaces
        //Supplier<T> dönüş tipini belirtir.
        // herhangi bir nesneden üretmek için kullanılır.
        // T get() functional metodu vardır.
        //Bu metot üzerinden çalışır.0
        Supplier<LocalDate> tarih=()->LocalDate.now();
        //Supplier<LocalDate> tarih=LocalDate::now(); //LocalDate'te bulunan metodu direkt çağırabiliriz
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate bugun=tarih.get();
        System.out.println(formatter.format(bugun));

        Supplier<ArrayList<String>> liste=ArrayList<String>::new;

        List<String> yeniListe=liste.get();
        System.out.println(yeniListe.getClass());

        //Consumer - BiConsumer <T> input tipini belirtir
        //void accept(T t) metodu ile çalışır. bir işi yaptıran metotdur
        //BiConsumer void accept(T t, U u)
        Consumer<String> c1=System.out::println;

        c1.accept("Mahmut");

        Map<String,String> myMap=new HashMap<>();
        BiConsumer<String,String> b1=myMap::put;
        b1.accept("ali","at");


        //Predicate<T> , BiPredicate<T,U>
        //Boolean test(T t) metodu ile çalışır. Gönderdiğimiz bir ifadenin true/false kontrolünü yapar
        Predicate<String> p1=String::isEmpty;
        System.out.println(p1.test(""));
        //Not predicate geriye primitive boolean döndürür eğer nesne olarak wrapper Boolean döndürmesini
        //istiyorsak function kullanacağız

        BiPredicate<String,String> p2=String::startsWith;
        //ali a ile mi başlar?
        System.out.println(p2.test("ali","a"));

        //Function <T,R> BiFunction<T,U,R>
        //Function T tipinde bir veriyi R tipinde bir veriye dönüştürüp geri veriyor
        //T apply(T t) ve T apply(T t,U u)

        //Verdiğim bir string ifadenin integer tipinde uzunluğunu veriyor.
        Function<String,Integer> f1=String::length;
        System.out.println(f1.apply("seyda"));

        //2 tane veri alıp onları değiştirip üçüncü türde geri döndürüyor.
        BiFunction<String,String,String> f2=String::concat;
        System.out.println(f2.apply("ali","veli")); //2 string i birleştirip geriye string döndürüyor.

        //UnaryOperator - BinaryOperator
        //Function'ın özel bir türüdür
        //Gönderilen değeri aynı türde dönüştür.
        //T apply(T t) fonksiyonu ile çalışır
        UnaryOperator<String> u1=String::toLowerCase; //String ifadeyi küçük harflerine dönüştürür

        System.out.println(u1.apply("SeydA"));

        BinaryOperator<String> bn1=String::concat;
        BinaryOperator<Integer> bn2=(r1 , r2)->r1.compareTo(r2); //Integer::compareTo;
        System.out.println(bn1.apply("mehmet","Hasan"));
        System.out.println(bn2.apply(4,10));











    }
}
