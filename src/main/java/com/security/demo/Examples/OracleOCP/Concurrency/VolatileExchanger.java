package com.security.demo.Examples.OracleOCP.Concurrency;

public class VolatileExchanger {
    private int val1=0;
    private int val2=0;
    private volatile int val3=0;

    public void setValues(Values source){

        this.val2=source.getVal2();
        this.val3=source.getVal3();
        this.val1=source.getVal1();
    }

    public void getValues(Values dest){


        dest.setVal1(this.val1*2);
        dest.setVal2(this.val2*2);
        dest.setVal3(this.val3*2);
    }

    public static void main(String[] args) {
        Values values=new Values();
        values.setVal3(10);
        values.setVal2(15);
        values.setVal1(20);

        VolatileExchanger volatileExchanger=new VolatileExchanger();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                volatileExchanger.setValues(values);

            }
        });

        Values v2=new Values();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                volatileExchanger.getValues(v2);
                System.out.println(v2.getVal1()+ " - "+v2.getVal2()+" - "+v2.getVal3());
            }
        });

        t1.start();
        t2.start();


    }
}
class Values{
    int val1;
    int val2;
    int val3;

    public int getVal1() {
        return val1;
    }

    public int getVal2() {
        return val2;
    }

    public int getVal3() {
        return val3;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    public void setVal3(int val3) {
        this.val3 = val3;
    }
}
