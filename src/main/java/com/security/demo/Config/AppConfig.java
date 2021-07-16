package com.security.demo.Config;

import com.security.demo.Examples.Threads.MainThreads_1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean//Bean yaratılırken direct calıştırılıyor.
    public MainThreads_1 startThread(){
        MainThreads_1 thread_1=new MainThreads_1();
        return thread_1;
    }
}
