package com.security.demo.Examples.Siniflar.Exceptions;

public class DivisionByZeroExample {
    public static void main(String[] args) {
        //divide(10,0);

//        try{
//           divide(10 ,0);
//        }catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }
        try{
            divideWithThrowsException(19,0);
        }catch (ArithmeticException a){
            //burada uygun bir exception nesnesi bulunamazsa jvm crashes and exits.
            System.out.println(a.getMessage());
        }



    }
    public static void divide(int a,int b){
        System.out.println("sonuc : " + (a/b));
    }

    public static void divideWithThrowsException(int a,int b){
        if(b==0){
            //unchecked exception
            throw new ArithmeticException("0'a bölemezsiniz...");
        }else{
            System.out.println("sonuc: "+(a/b));
        }
    }
}
