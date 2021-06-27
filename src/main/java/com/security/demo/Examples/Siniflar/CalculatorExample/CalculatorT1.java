package com.security.demo.Examples.Siniflar.CalculatorExample;

import java.util.ArrayList;
import java.util.List;

public class CalculatorT1 implements Calculator{
    private List<MathFunction> myFunctions;

    public CalculatorT1() {
        this.myFunctions = new ArrayList<>();
    }

    @Override
    public void addFunction(MathFunction mathFunction) {
        this.myFunctions.add(mathFunction);
    }

    @Override
    public void listMathFunction() {
        for(MathFunction i:myFunctions){
            System.out.println(i);
        }
    }

    @Override
    public double doCalculation(String functionName, Arguments arguments) {
        MathFunction mathFunction=null;
        for(MathFunction i:myFunctions){
            if(i.getName().equals(functionName)){
                mathFunction=i;
            }
        }
        if(mathFunction!=null){
            return mathFunction.calculate(arguments);
        }
        return 0;
    }
}
