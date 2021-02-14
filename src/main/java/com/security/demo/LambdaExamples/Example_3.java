package com.security.demo.LambdaExamples;

public class Example_3 {
    public static void main(String[] args) {

        AnotherClass anotherClass=new AnotherClass();
        String s=anotherClass.doSomething();
        System.out.println(s);
        System.out.println(anotherClass.lambdaExample());
    }

    public final static String doStringSth(UpperConcat uc,String s1,String s2){
        return uc.upperAndConcat(s1,s2);
    }
}

class AnotherClass{
    public String doSomething(){
        return Example_3.doStringSth(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase()+s2.toUpperCase();
            }
        },"String 1","String 2");
    }

    public String lambdaExample(){
        //UpperConcat interface'ine ait upperAndConcat methodunu somutlaştırıyoruz ya da implemente ediyoruz...
        UpperConcat uc=(s1,s2)-> s1.toUpperCase()+s2.toUpperCase();
        //somutlaşan metodu kullanması için doStringSth metoduna veriyoruz.
        return Example_3.doStringSth(uc,"String 1**","String 2**");
    }

}
