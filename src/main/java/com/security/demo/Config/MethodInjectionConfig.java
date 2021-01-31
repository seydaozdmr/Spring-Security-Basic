package com.security.demo.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.security.demo.MethodInjection"})
public class MethodInjectionConfig {

//    @Bean(name="singer")
//    public Singer singer(){
//        return new Singer();
//    }

//    @Bean(name="abstractLookupBean")
//    public AbstractLookupDemoBean getMySinger(){
//        return new AbstractLookupDemoBean() {
//            @Override
//            public Singer getMySinger() {
//                return singer();
//            }
//        };
//    }

//    @Bean(name="standartLookupBean")
//    public StandartLookUpDemoBean setMySinger(){
//        StandartLookUpDemoBean standartLookUpDemoBean=new StandartLookUpDemoBean();
//        standartLookUpDemoBean.setMySinger(new Singer());
//        return standartLookUpDemoBean;
//    }
//    @Bean(name="standartLookupBean")
//    public StandartLookUpDemoBean setMySinger(){
//        return new StandartLookUpDemoBean();
//    }
}
