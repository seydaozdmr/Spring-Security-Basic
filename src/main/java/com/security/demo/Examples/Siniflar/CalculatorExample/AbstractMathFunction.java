package com.security.demo.Examples.Siniflar.CalculatorExample;

public abstract class AbstractMathFunction implements MathFunction {
    private String name;

    public AbstractMathFunction(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
