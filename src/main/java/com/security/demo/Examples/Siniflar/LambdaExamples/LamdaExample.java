package com.security.demo.Examples.Siniflar.LambdaExamples;

import java.util.Arrays;
import java.util.function.IntFunction;

public class LamdaExample {
    //lamba fonksiyonları isimsiz fonskiyonlardır
    public static void main(String[] args) {
        Runnable merhaba_dünya = () -> System.out.println("merhaba dünya");
        merhaba_dünya.run();

        IntFunction<Integer> integerIntFunction = x -> x * x;
        System.out.println(integerIntFunction.apply(10));

        //lambda expression ı parametre olarak alan fonsiyonlara yüksek seviyeli fonksiyonlar denir.
        Arrays.stream(new int[]{1,2,3,4,5,6}).map(x->x*x).forEach(System.out::println);
        //(map eşleştirme, reduce indirgeme , filter eleme)

        //toplama işlemi
        System.out.println(islemYap(10,15, (a,b)->a+b));

        //çarpma işlemi
        System.out.println(islemYap(2, 8, new DoOperation() {
            @Override
            public double doOperation(double a, double b) {
                return a*b;
            }
        }));

        //mod
        System.out.println(islemYap(100,3,(a,b)->a%b));


    }
    private static double islemYap(double a,double b , DoOperation doOperation){
        return doOperation.doOperation(a,b);
    }
}
