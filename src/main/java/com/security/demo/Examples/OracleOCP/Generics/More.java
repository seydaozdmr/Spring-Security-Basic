package com.security.demo.Examples.OracleOCP.Generics;

import java.io.ObjectInputStream;
import java.util.List;

public class More {
    public static <T> void sink(T t){

    }

    public static <T> T identity(T t){
        return t;
    }

    public static void printList(List<Object> liste){
        for(Object o:liste){
            System.out.println(o);
        }
    }

    public static void printList2(List<?> liste){
        for(Object o:liste){
            System.out.println(o);
        }
    }

}
