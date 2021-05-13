package com.security.demo.Examples.OracleOCP.IOExamples;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
    private static final long serialVersionUID=1L;

    private String name;
    private String lastName;
    private LocalDate kayitTarihi;

    public Student(String name, String lastName, LocalDate kayitTarihi) {
        this.name = name;
        this.lastName = lastName;
        this.kayitTarihi = kayitTarihi;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(LocalDate kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", kayitTarihi=" + kayitTarihi +
                '}';
    }
}
