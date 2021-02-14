package com.security.demo.LambdaExamples;

import java.util.*;

public class Example_1 {
    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("printing from the new Runnable");
            }
        }).start();
        //bir interface'de implement edilmesi gereken bir metot bulunuyorsa buna functional interface denir.
        new Thread(()-> System.out.println("Printing lambla runnable")).start();

        //bir lambda 'da birden çok kod bloğu bulunursa:
        new Thread(()->{
            System.out.println("birinci ifade");
            System.out.println("ikinci ifade");
            System.out.println("üçüncü ifade");
        }).start();


        //Çalışan sınıfımızın uygulanması:
        Calisan ali=new Calisan("Ali",21);
        Calisan hasan=new Calisan("Hasan",33);
        Calisan mehmet=new Calisan("Mehmet",44);
        Calisan yasin=new Calisan("Yasin",21);

        List<Calisan> calisanList=new ArrayList<>();
        calisanList.add(yasin);
        calisanList.add(ali);
        calisanList.add(mehmet);
        calisanList.add(hasan);

//        Collections.sort(calisanList, new Comparator<Calisan>() {
//            @Override
//            public int compare(Calisan o1, Calisan o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        Collections.sort(calisanList,(Calisan o1,Calisan o2)->
                o1.getName().compareTo(o2.getName()));

        for(Calisan calisan:calisanList){
            System.out.println(calisan.getName()+" "+calisan.getAge());
        }

    }

}
//bu sınıfımızı lambda uygulamasını göstermek için oluşturacağız.

class Calisan{
    private String name;
    private int age;

    public Calisan(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



class CodeToRun implements Runnable{

    @Override
    public void run() {
        System.out.println("Printing runnable");
    }
}
