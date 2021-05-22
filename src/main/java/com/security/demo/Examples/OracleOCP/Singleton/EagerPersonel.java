package com.security.demo.Examples.OracleOCP.Singleton;

public class EagerPersonel {
    private static final EagerPersonel INSTANCE=new EagerPersonel();
    private Object object;
    private EagerPersonel(){
        object=new Object();
    }

    public static EagerPersonel getInstance(){
        return INSTANCE;
    }

    public void eagerSingleto(){
        System.out.println(object.toString()+" eager singleton");
    }

}
