package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E2CreatingRunnableClass {
    public static void main(String[] args) {
        Test test=new Test();
        test.run();
    }

}
class Test implements Runnable{

    @Override
    public void run() {
        System.out.println("hello world");
    }
}
