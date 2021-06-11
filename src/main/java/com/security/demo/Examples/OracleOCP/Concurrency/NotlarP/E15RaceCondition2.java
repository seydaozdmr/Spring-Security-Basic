package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;



public class E15RaceCondition2 {
    public static void main(String[] args) throws InterruptedException {
        Values values=new Values(1,2,3);
        Values v2=new Values();

        ValueExchanger valueExchanger=new ValueExchanger();

        Runnable runnable=()->valueExchanger.get(values);
        Runnable runnable1=()->valueExchanger.set(v2);

        Thread thread=new Thread(runnable);
        Thread thread1=new Thread(runnable1);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
        System.out.println(v2);

    }
}

class Values{
    public int valA;
    public int valB;
    public int valC;

    public Values(){}

    public Values(int valA, int valB, int valC) {
        this.valA = valA;
        this.valB = valB;
        this.valC = valC;
    }


    @Override
    public String toString() {
        return "Values{" +
                "valA=" + valA +
                ", valB=" + valB +
                ", valC=" + valC +
                '}';
    }
}

class ValueExchanger{
    private int valA;
    private int valB;
    private int valC;

    public void set(Values v){
        synchronized (this){
            this.valA=v.valA;
            this.valB=v.valB;
            this.valC=v.valC;
        }

    }

    public void get(Values v){
        synchronized (this){
            v.valA=this.valA;
            v.valB=this.valB;
            v.valC=this.valC;
        }

    }
}
