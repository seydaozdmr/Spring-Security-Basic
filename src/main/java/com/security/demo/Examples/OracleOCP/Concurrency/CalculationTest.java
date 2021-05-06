package com.security.demo.Examples.OracleOCP.Concurrency;

public class CalculationTest {
    public static void main(String[] args) {
        Calculator calculator=new Calculator();

        Calculator.Calculation c1=new Calculator.Calculation(0,150);
        Calculator.Calculation c2 =new Calculator.Calculation(0,200);
        Calculator.Calculation c3 =new Calculator.Calculation(1,100);
        calculator.calculate(c1,c2,c3);


        System.out.println(calculator.getResult());
    }
}
