package com.security.demo.Examples.Siniflar.CalculatorExample;

public interface Calculator {
    //program interface not implementation
    //depend on abstractions not concretions
    void addFunction(MathFunction mathFunction);
    void listMathFunction();
    double doCalculation(String functionName, Arguments arguments);
}
