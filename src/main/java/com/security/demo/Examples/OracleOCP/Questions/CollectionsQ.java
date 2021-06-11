package com.security.demo.Examples.OracleOCP.Questions;



import java.util.*;

public class CollectionsQ {
    public static void main(String[] args) {
        //HashSet<Number> hs=new HashSet<Integer>(); must same type

        HashSet<? super ClassCastException> set=new HashSet<Exception>();

        set.add(new ClassCastException());

        //List<> liste=new ArrayList<String>(); //does not compile

        //List<Object> values=new HashSet<Object>(); //not inherited


        //List<Object> objects=new ArrayList<? extends Object>();

        Map<String, ? extends Number> myMap=new HashMap<String,Integer>();

        Platypus p1=new Platypus("Ali",3);
        Platypus p2=new Platypus("Hasan",5);
        Platypus p3=new Platypus("Mehmet",7);

        List<Platypus> list=Arrays.asList(p1,p2,p3);
        System.out.println(list.getClass());

        Collections.sort(list,Comparator.comparing(Platypus::getSayi).reversed());
        System.out.println(list);

        Map m=new HashMap();
        m.put(123,"456");
        m.put("abc","def");
        System.out.println(m.containsKey("123"));



    }

    public static <T> T identiy(T t){
        return t;
    }

}


