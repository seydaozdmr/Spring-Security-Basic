package com.security.demo.Examples.Siniflar.Kurslar;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Student s1=new Student("Jack" , "Software Engineer Student","jack07");
        Teacher t1=new Teacher("John","Teacher of Java","john2234");

        Lesson d1=new Lesson(1,"Data structures",25.51);
        Lesson d2=new Lesson(2,"Algorithms",23.25);
        Lesson d3=new Lesson(3,"OOP",36.25);
        Lesson d4=new Lesson(4,"DevOps",26.15);
        Lesson d5=new Lesson(5,"DataBases",12.12);

        Course course=new Course("Advance Java",t1);
        course.addLessonToCourse(d1);
        course.addLessonToCourse(d2);
        course.addLessonToCourse(d3);
        course.addLessonToCourse(d4);
        course.addLessonToCourse(d5);

        s1.enrollCourse(course);

        System.out.println(course);
        s1.addLessons(d5);

        PlayLessonsList(s1.getLessonsOfStudent());
    }

    public static void PlayLessonsList(LinkedList<Lesson> lessonsOfStudent){
        for(Lesson l:lessonsOfStudent){
            System.out.println(l.getDersBaslik());
        }
    }
}
