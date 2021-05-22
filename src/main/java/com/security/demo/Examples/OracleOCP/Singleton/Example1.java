package com.security.demo.Examples.OracleOCP.Singleton;

public class Example1 {
    public static void main(String[] args) {
        //Personel p1=Personel.getPersonel("seyda","özdemir");
        Personel.getDetay();

        EagerPersonel.getInstance().eagerSingleto();
        EagerPersonel.getInstance().eagerSingleto();
        EagerPersonel.getInstance().eagerSingleto();
        EagerPersonel.getInstance().eagerSingleto();

        StaticBlock staticBlock=StaticBlock.getInstance();
        StaticBlock.getInfo();

        //inner static private class instance
        BillPughExample.getInstance().test();


    }
}
