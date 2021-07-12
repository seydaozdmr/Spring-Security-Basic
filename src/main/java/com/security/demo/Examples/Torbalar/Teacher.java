package com.security.demo.Examples.Torbalar;

import java.util.Objects;

//if we use Teacher objects in List<Teacher> , then it could sort by implementing Comparable
public class Teacher implements Comparable<Teacher> {
    private int id;
    private String name;
    private String lastName;

    public Teacher(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    //We design how compare Teachers each other by compareTo():
    @Override
    public int compareTo(Teacher o) {
        return name.compareTo(o.getName());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(name, teacher.name) && Objects.equals(lastName, teacher.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName);
    }
}
