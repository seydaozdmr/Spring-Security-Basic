package com.security.demo.Examples.Siniflar.Exceptions;

public class NegativeArgumentException  extends Exception{
    private double value;

    public NegativeArgumentException(String message, double value) {
        super(message);
        this.value = value;
    }

    public NegativeArgumentException(String message) {
        super(message);
    }

    public double getValue() {
        return value;
    }
}
