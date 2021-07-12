package com.security.demo.Examples.Torbalar;

import org.apache.logging.log4j.util.PropertySource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableWithComparator {
    public static void main(String[] args) {
        List<Teacher> teacherList=new ArrayList<>();
        teacherList.add(new Teacher(2,"Hasan" ,"Yılmaz"));
        teacherList.add(new Teacher(3,"Ali","Okuyan"));
        teacherList.add(new Teacher(1,"Ramazan","Norcu"));

        //we implements comparable at Teacher class
        Collections.sort(teacherList);

        teacherList.forEach(a->System.out.println(a));

        //if we want to write own comparator method
        teacherList.add(new Teacher(2,"Hasan","Karabacak"));
        Collections.sort(teacherList, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;
                }else {
                    return o1.compareTo(o2);
                }
            }
        });

        teacherList.forEach(System.out::println);

        Comparator<Teacher> comparaByName= (t1,t2)->t1.getName().compareTo(t2.getName());
        Collections.sort(teacherList,comparaByName);

        teacherList.forEach(System.out::println);

        Comparator<Teacher> comparatorByNameCompareByLastName =comparaByName.thenComparing((t1,t2)->t1.getLastName().compareTo(t2.getLastName()));
        Collections.sort(teacherList,comparatorByNameCompareByLastName);
        teacherList.forEach(System.out::println);

    }
}
