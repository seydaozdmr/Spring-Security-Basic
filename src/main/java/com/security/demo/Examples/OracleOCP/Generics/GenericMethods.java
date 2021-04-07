package com.security.demo.Examples.OracleOCP.Generics;

public class GenericMethods {
    public static <T> void preare(T t){
        System.out.println("printing : "+t);
    }

    public static <T> Crate<T> ship(T t){
        System.out.println("shipping : "+t);
        return new Crate<T>();
    }
}
