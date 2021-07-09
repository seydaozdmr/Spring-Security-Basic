package com.security.demo.Examples.Siniflar.LambdaExamples;

public class EvenNumberOperationTestClass {
    public static void main(String[] args) {
        EvenNumberOperation topla = new EvenNumberOperation() {
            @Override
            public void operate(int n) {
                for(int i=0;i<n;i++){
                    if(i%2==0){
                        System.out.println(i);
                    }
                }
            }
        };

        EvenNumberOperation carp= new EvenNumberOperation() {
            @Override
            public void operate(int n) {
                for(int i=0;i<n;i++){
                    if(i%2==0){
                        System.out.println(i*i);
                    }
                }
            }
        };

        carp.operate(10);

    }
}
