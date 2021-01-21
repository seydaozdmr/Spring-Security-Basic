package com.security.demo;

import com.security.demo.Config.AppConfig;
import com.security.demo.Threads.MainThreads_1;
import com.security.demo.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//ApplicationContext ctx=new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
		//MainThreads_1 thread=(MainThreads_1) ctx.getBean("startThread");


	}

}
