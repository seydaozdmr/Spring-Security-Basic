package com.security.demo.Examples.Siniflar.CalculatorExample;

public class SquaredFunction extends AbstractMathFunction{


    public SquaredFunction(String name) {
        super(name);
    }

    @Override
    public double calculate(Arguments arguments) {
        return Math.sqrt(arguments.getArguments().get(arguments.getArgumentAmount()-1));
    }
}
