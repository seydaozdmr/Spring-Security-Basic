package com.security.demo.Examples.Siniflar.CalculatorExample;

public class TestClass {
    public static void main(String[] args) {
        Arguments arguments=new Argument(1.5);
        Calculator calculator=new CalculatorT1();
        MathFunction mathFunction=new SinFunction("Sin");
        MathFunction toplama=new SumFunction("Sum");
        calculator.addFunction(mathFunction);
        calculator.addFunction(toplama);

        double result=calculator.doCalculation("Sin",arguments);

        System.out.println(result);

        double sonuc=calculator.doCalculation("Sum",new Argument(5,10));
        System.out.println("toplama sonucu : "+sonuc);
    }
}
