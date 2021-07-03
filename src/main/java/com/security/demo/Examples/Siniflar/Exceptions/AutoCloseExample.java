package com.security.demo.Examples.Siniflar.Exceptions;

public class AutoCloseExample {
    public static void main(String[] args) {
        run1();
        run2();
        System.out.println("******************");
        run3();
    }
    public static void run1(){
        CloseableClass cc=null;
        try {
            cc=new CloseableClass("unique" , false);
            System.out.println("in try block");
            throwException();
            cc.close();
        }catch (Exception e){
            System.out.println("in catch block");
            try{
                if(cc.isOpen()){
                    cc.close();
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }finally {
            System.out.println("in finally");
            try{
                if(cc.isOpen())
                    cc.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public static void run2(){
        try(CloseableClass cc=new CloseableClass("yeni",false)){
            System.out.println("in autoclose try");
        }catch (Exception e){
            System.out.println("in autoclose catch");
        }finally {
            System.out.println("in autoclose finally");
        }
    }

    public static void run3(){
        try(CloseableClass c1=new CloseableClass("first",false); CloseableClass c2=new CloseableClass("second" , false)){
            System.out.println("in run3 try");
            throwException();
        }catch (Exception e){
            System.out.println("in run3  catch");
            e.printStackTrace();
        }finally {
            System.out.println("run3 finally");
        }
    }

    public static void throwException() throws Exception{
        double random = Math.random();
        if(random<0.5){
            System.out.println("Throwing an exception");
            throw new Exception();
        }
    }

}
