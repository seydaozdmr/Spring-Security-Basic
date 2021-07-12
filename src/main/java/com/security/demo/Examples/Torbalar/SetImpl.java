package com.security.demo.Examples.Torbalar;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
public class SetImpl {
    public static void main(String[] args) {
        //HashSet arka planda HashMap çalıştırır
        Collection<String> mySet=new HashSet<>();
        mySet.add("ankara");
        mySet.add("izmir");
        //add if not exits already
        System.out.println(mySet.add("adana"));
        if(!mySet.add("adana"))
            System.out.println("dublicate item");
        Iterator<String> myIterator = mySet.iterator();
        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }

        //Set<String> mySet1=Set.of("ali","hasan","aydın");
//        Set<String> copySet=Set.copyOf(mySet1);
//        System.out.println(copySet);

        Set<Teacher> teachers= new TreeSet<>();
        teachers.add(new Teacher(2,"Hasan" ,"Yılmaz"));
        teachers.add(new Teacher(3,"Ali","Okuyan"));
        teachers.add(new Teacher(1,"Ramazan","Norcu"));

        teachers.forEach(System.out::println);

    }
}
