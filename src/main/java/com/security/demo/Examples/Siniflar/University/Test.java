package com.security.demo.Examples.Siniflar.University;

public class Test {
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("Akın Kaldıroğlu");
        Student [] students=new Student[100];
        students[0]=student;

        Professor aliProf=new Professor();
        aliProf.setName("Ali Yılmaz");
        aliProf.setId(1);
        aliProf.setStudents(students);

        Course javaCourse=new Course();
        javaCourse.setName("Java 101");
        javaCourse.setStudents(students);
        Course [] courses=new Course[100];
        courses[0]=javaCourse;

        Department csDepartment=new Department();
        csDepartment.setName("CS");
        csDepartment.setStudents(students);
        csDepartment.setCourses(courses);
        csDepartment.setHead(aliProf);


        javaCourse.setDepartment(csDepartment); //setting department
        javaCourse.setProfessor(aliProf);
        aliProf.setCourses(courses); //aliProf'un kursları
        aliProf.setDepartment(csDepartment); //aliProf'un departmanı

        student.setProfessor(aliProf);
        student.setCourses(courses);

        Classroom classroom=new Classroom();
        classroom.setId(1);
        classroom.setName("A");
        classroom.setGrade("11");
        classroom.setStudents(students);
        classroom.setGivenCourses(courses);
        classroom.setProfessor(aliProf);

        javaCourse.setClassroom(classroom);


        System.out.println("öğrencinin aldığı dersin adı : "+student.getCourses()[0].getName());
        System.out.println("Java dersi hangi sınıfta : "+ javaCourse.getClassroom().getName() + javaCourse.getClassroom().getGrade() );


    }
}
