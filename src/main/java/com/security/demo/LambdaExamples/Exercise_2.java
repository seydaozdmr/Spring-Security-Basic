package com.security.demo.LambdaExamples;

import java.util.function.Function;

public class Exercise_2 {
    public static void main(String[] args) {
        String source="Şampiyon Fenerbahçe";

        Function<String, String > lamdaFunction = s  -> {
            StringBuilder stringBuilder=new StringBuilder();

            for(int i=0;i<s.length();i++){
                if(i%2==1){
                    stringBuilder.append(s.charAt(i));
                }
            }

            return  stringBuilder.toString();
        };

        //Sonucu almak için lambdaFunction'ı apply ile uyguluyoruz.
        String sonuc=lamdaFunction.apply(source);
        System.out.println(sonuc);


    }

}
