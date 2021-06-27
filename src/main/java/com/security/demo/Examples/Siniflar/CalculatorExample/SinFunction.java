package com.security.demo.Examples.Siniflar.CalculatorExample;

public class SinFunction extends AbstractMathFunction{

    public SinFunction(String name){
        super(name);
    }

    @Override
    public double calculate(Arguments arguments) {
        return Math.sin(arguments.getArguments().get(arguments.getArgumentAmount()-1));
    }
}
