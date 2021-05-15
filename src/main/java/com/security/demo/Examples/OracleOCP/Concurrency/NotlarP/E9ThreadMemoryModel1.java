package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E9ThreadMemoryModel1 {
    public static void main(String[] args) {
        //myLocalInt ThreadStack'de bulunur.
        int myLocalInt=0;
        //referansı Thread Stack'da çalışır. Text değeri ise heap'de bulunur
        String myLocalString="Text";

        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                //myLocalInt++;
            }
        };
        Runnable runnable2=new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread thread1=new Thread(runnable1,"Thread -1 ");
        Thread thread2=new Thread(runnable2,"Thread -2");
        thread1.start();
        thread2.start();

    }
}
