package com.security.demo.Examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Collections_Example {
    public static void main(String[] args) {
        Student s1=new Student("John",1);
        Student s2=new Student("Hans",3);
        Student s3=new Student("Micheal",2);
        Student s4=new Student("Janet",4);

        ArrayList<Student> liste=new ArrayList<>();
        liste.add(s1);
        liste.add(s2);
        liste.add(s3);
        liste.add(s4);
        Student enBuyuk= Collections.max(liste, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.id>o2.id)
                    return 1;
                else if(o1.id<o2.id)
                    return -1;
                else
                    return 0;
            }
        });
        System.out.println(enBuyuk);

        Collections.sort(liste);

        liste.forEach(i-> System.out.println(i));

        //İkili Arama -- BinarySearch *elemanlar sıralı olmak zorundadır

        int index=Collections.binarySearch(liste,s3);
        System.out.println(index);

        //Ters sıralama
        Collections.reverse(liste);
        ArrayList<Student> yedekListe=new ArrayList<>(100);
        Collections.copy(yedekListe,liste);
        System.out.println(yedekListe);
    }
}
class Student implements Comparable<Student>{
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        if(this.id>o.id)
            return 1;
        else if(this.id<o.id)
            return -1;
        else
            return 0;
    }
}
