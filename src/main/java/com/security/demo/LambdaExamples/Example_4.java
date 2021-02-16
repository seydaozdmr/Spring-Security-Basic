package com.security.demo.LambdaExamples;


import java.util.*;
import java.util.stream.Collectors;

public class Example_4 {
    public static void main(String[] args) {
        Personel ali=new Personel("ali",23);
        Personel mehmet=new Personel("mehmet",54);
        Personel yasin=new Personel("yasin",32);
        Personel kemal =new Personel("kemal",55);


        List<Personel> list=new ArrayList<>();
        list.add(ali);
        list.add(kemal);
        list.add(yasin);
        list.add(mehmet);

        list.stream()
                .filter(e -> e.getAge()>33)
                .forEach(e -> System.out.println(e.getName()));
        //you could easily request a parallel stream, which might make sense if the collection is large enough and your computer has enough cores
        list.parallelStream()
                .forEach(e-> System.out.println(e.getName()));
        //String aggregate operations:

        String joined=list.stream().map(Personel::toString).collect(Collectors.joining(","));
        System.out.println(joined);

        int total = list.stream().collect(Collectors.summingInt(Personel::getAge));
        System.out.println("toplam yaş: "+total);

        filter(list);
        System.out.println(list.size());


    }
    static void filter (Collection<?> c){
        for(Iterator<?> it =c.iterator(); it.hasNext(); )
            if(!it.hasNext())
                it.remove();
    }

}

class Personel implements Comparable{
    private String name;
    private int age;

    public Personel(String name, int age) {
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

    @Override
    public String toString() {
        return "Personel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personel personel = (Personel) o;
        return age == personel.age &&
                name.equals(personel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //compareTo metodu ile personelimizin isminin ilk harfini baz alarak kıyaslama gerçekleştiriyoruz.
    @Override
    public int compareTo(Object o) {
        if(this.getName().charAt(0) > ((Personel)o).getName().charAt(0)){
            return -1;
        }else if(this.getName().charAt(0) < ((Personel)o).getName().charAt(0)){
            return 1;
        }else{
            return 0;
        }
    }
}
