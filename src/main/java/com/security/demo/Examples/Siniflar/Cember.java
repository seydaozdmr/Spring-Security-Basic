package com.security.demo.Examples.Siniflar;

public class Cember {
    private int r;
    private final double pi=3.14;

    public Cember(int r){
        this.r=r;
    }

    public double cevre(){
        return 2*pi*r;
    }

    public double alan(){
        return pi*r*r;
    }
}
