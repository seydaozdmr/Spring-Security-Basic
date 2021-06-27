package com.security.demo.Examples.Siniflar.CalculatorExample;

public class SumFunction extends AbstractMathFunction{

    public SumFunction(String name) {
        super(name);
    }

    @Override
    public double calculate(Arguments arguments) {
        if(arguments.getArgumentAmount()==2){
            return arguments.getArguments().get(0) + arguments.getArguments().get(1);
        }
        return 0;
    }
}
