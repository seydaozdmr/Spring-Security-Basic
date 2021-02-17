package com.security.demo.LambdaExamples;

public class Example_12 {
    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        IntegerMath carpim=(x,y)->x*y;
        IntegerMath toplam=(x,y)->x+y;

        System.out.println("3 x 4 = "+calculator.operationBinaery(3,4,carpim));
        System.out.println("4 + 5 = "+calculator.operationBinaery(4,5,toplam));

    }
}
class Calculator{
    public int operationBinaery(int x,int y,IntegerMath op){
        return op.operation(x,y);
    }
}

interface IntegerMath{
    int operation(int x,int y);
}
