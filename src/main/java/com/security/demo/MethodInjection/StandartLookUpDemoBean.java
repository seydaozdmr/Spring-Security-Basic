package com.security.demo.MethodInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standartLookupBean")
public class StandartLookUpDemoBean implements DemoBean {
    private Singer singer;

    @Autowired
    @Qualifier("singer")
    public void setMySinger(Singer mySinger){
        this.singer=mySinger;
    }

    @Override
    public Singer getMySinger() {
        return this.singer;
    }

    @Override
    public void doSomething() {
        //singer nesnesine ait sing metodunu çağırıyoruz.
        singer.sing();
    }

}
