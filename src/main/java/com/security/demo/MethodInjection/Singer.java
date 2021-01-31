package com.security.demo.MethodInjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
@Scope("prototype")
public class Singer {
    private String lyric="Ben de yoluma giderim. \n Ezdirmem kendimi";

    public void sing(){
        System.out.println(this.lyric);
    }
}
