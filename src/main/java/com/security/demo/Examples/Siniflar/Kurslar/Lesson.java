package com.security.demo.Examples.Siniflar.Kurslar;

public class Lesson {
    private int dersNo;
    private String dersBaslik;
    private double dakika;

    public Lesson(int dersNo, String dersBaslik, double dakika) {
        this.dersNo = dersNo;
        this.dersBaslik = dersBaslik;
        this.dakika = dakika;
    }

    public double getDakika() {
        return dakika;
    }

    public String getDersBaslik() {
        return dersBaslik;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "dersNo=" + dersNo +
                ", dersBaslik='" + dersBaslik + '\'' +
                ", dakika=" + dakika +
                '}';
    }
}
