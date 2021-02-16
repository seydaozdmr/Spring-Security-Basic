package com.security.demo.LambdaExamples;

public class Example_3 {
    public static void main(String[] args) {

        AnotherClass anotherClass=new AnotherClass();
        String s=anotherClass.doSomething();
        System.out.println(s);
        System.out.println(anotherClass.lambdaExample());
        System.out.println(anotherClass.doSomething2());
        anotherClass.printValue();
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

    public String doSomething2(){
        int i=0;


        UpperConcat uc=(s1,s2)->{
            System.out.println("the lambda expression's class is: "+getClass().getName());
            System.out.println("i in the lambda expression : "+i);
            String result=s1.toUpperCase()+s2.toUpperCase();
            return result;
        };
        System.out.println("The another class's name is: "+getClass().getName());
        return Example_3.doStringSth(uc,"String 1---","String 2---");
    }

    public void printValue(){
        int number =25;
        Runnable r=()->{
            try{
                Thread.sleep(250);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println("number : "+number);
        };
        new Thread(r).start();
    }

}
