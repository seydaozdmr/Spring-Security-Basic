package com.security.demo.Examples.Siniflar.Kurslar;

import java.util.ArrayList;
import java.util.LinkedList;

public class Student extends Person {

    private ArrayList<Course> participationOfCourses;
    private LinkedList<Lesson> lessonsOfStudent;

    public Student(String name, String description, String userName) {
        super(name, description, userName);
        this.participationOfCourses=new ArrayList<>();
        this.lessonsOfStudent=new LinkedList<>();
    }

    public void enrollCourse(Course course){
        if(course.isOnline()){
            //This class instance will add to course
            course.getStudents().add(this);
            this.participationOfCourses.add(course);
            System.out.println(this.getName() + " user enrolled : "+ course.getCourseName());
        }else{
            System.out.println("Couldn't enroll the course :"+course.getCourseName());
        }

    }

    public LinkedList<Lesson> getLessonsOfStudent() {
        return lessonsOfStudent;
    }

    public void addLessons(Lesson lesson){
        boolean found=false;
        if(participationOfCourses.size()>0){
            for(Course c:participationOfCourses){
                if(c.getLessons().contains(lesson)){
                    System.out.println("Lesson of students list added : "+lesson.getDersBaslik());
                    this.lessonsOfStudent.add(lesson);
                    found=true;
                }
            }
            if(!found){
                System.out.println("Course don't contains lesson");
            }
        }
    }

    @Override
    public String toString() {
        return super.toString()+ "Student{" +
                "participationOfCourses=" + participationOfCourses +
                '}';
    }
}
