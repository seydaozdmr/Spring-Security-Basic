package com.security.demo.LambdaExamples;

import java.util.function.Function;

public class Exercise_3 {
    public static void main(String[] args) {
        String resource="Şampiyon Fener";

        Function<String, String > lamdaFunction = s  -> {
            StringBuilder stringBuilder=new StringBuilder();

            for(int i=0;i<s.length();i++){
                if(i%2==1){
                    stringBuilder.append(s.charAt(i));
                }
            }

            return  stringBuilder.toString();
        };

        String result=everySecondChar(lamdaFunction,resource);
        System.out.println(result);



    }

    private static String everySecondChar(Function<String,String> func , String source){
        return func.apply(source);
    }
}
