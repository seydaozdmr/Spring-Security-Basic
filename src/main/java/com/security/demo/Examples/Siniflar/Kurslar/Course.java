package com.security.demo.Examples.Siniflar.Kurslar;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Lesson> lessons;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private boolean online;

    public Course(String courseName ,Teacher teacher) {
        this.courseName = courseName;
        this.lessons=new ArrayList<>();
        this.teachers=new ArrayList<>();
        this.students=new ArrayList<>();
        teachers.add(teacher);
        this.online=false;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addTeacherToCourse(Teacher teacher){
        if(!this.teachers.contains(teacher)){
            this.teachers.add(teacher);
        }else{
            System.out.println("This record exists");
        }

    }

    public void deleteTeacherFromCourse(Teacher teacher){
        if(teacher.getName().equals(this.teachers.get(0).getName())){
            System.out.println("First record couldn't remove");
        }else{
            this.teachers.remove(teacher);
            System.out.println(teacher.getName()+" named record deleted");
        }
    }

    public void addLessonToCourse(Lesson lesson){
        this.lessons.add(lesson);
    }

    public int numberOfLesson(){
        return this.lessons.size();
    }

    private double totalMinOfLessons(){
        double totalMin=0;
        for(Lesson l:lessons){
            totalMin+=l.getDakika();
        }
        return totalMin;
    }

    public boolean isOnline(){
        if(lessons.size()>=5 && totalMinOfLessons()>=60){
            this.online=true;
            return  true;
        }else{
            return false;
        }
    }
}
