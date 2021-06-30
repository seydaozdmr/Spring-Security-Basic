package com.security.demo.Examples.Siniflar.CalculatorExample;

public class FiboFunction extends AbstractMathFunction{

    public FiboFunction(String name) {
        super(name);
    }

    @Override
    public double calculate(Arguments arguments) {
        int a=0;
        int b=1;
        int toplam=0;
        int result=0;
        for(int i=0;i<arguments.getArguments().get(0);i++){
            toplam=a+b;
            a=b;
            b=toplam;
            System.out.println("toplam "+toplam);
            result+=toplam;
        }
        return result;
    }
}
