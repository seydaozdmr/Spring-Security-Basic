package com.security.demo.Examples.Siniflar.MyDateExample;

public class Year {
    private int year;

    private Year(int i){
        if(i>=0 && i<3000){
            this.year=i;
        }else {
            throw new IllegalArgumentException("hatalı yıl girilmiştir");
        }

    }

    public static Year getYear(int i){
        return new Year(i);
    }

    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                '}';
    }
}
