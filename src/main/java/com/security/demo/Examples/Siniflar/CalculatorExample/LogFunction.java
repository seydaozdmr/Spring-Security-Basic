package com.security.demo.Examples.Siniflar.CalculatorExample;

public class LogFunction extends AbstractMathFunction{

    public LogFunction(String name){
        super(name);
    }

    @Override
    public double calculate(Arguments arguments) {
        return Math.log(arguments.getArguments().get(arguments.getArgumentAmount()-1));
    }
}
