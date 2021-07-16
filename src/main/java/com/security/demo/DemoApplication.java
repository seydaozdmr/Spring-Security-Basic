package com.security.demo;

import com.security.demo.Config.MethodInjectionConfig;
import com.security.demo.MethodInjection.DemoBean;
import com.security.demo.MethodInjection.Singer;
import com.security.demo.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StopWatch;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//ApplicationContext ctx=new AnnotationConfigReactiveWebApplicationContext(MethodInjectionConfig.class);
		//MainThreads_1 thread=(MainThreads_1) ctx.getBean("startThread");
		ApplicationContext ctx2=new AnnotationConfigApplicationContext(MethodInjectionConfig.class);

		DemoBean abstractBean=ctx2.getBean("abstractLookupBean" ,DemoBean.class);
		DemoBean standartBean=ctx2.getBean("standartLookupBean",DemoBean.class);

		//displayInfo("abstractLookupBean",abstractBean);
		//displayInfo("standartLookupBean",standartBean);



	}

	public static void displayInfo(String beanName,DemoBean bean){
		Singer singer1=bean.getMySinger();
		Singer singer2=bean.getMySinger();

		System.out.println(""+beanName+" :Singer instances the same? "+(singer1==singer2));

		StopWatch stopWatch=new StopWatch();
		stopWatch.start("lookupDemo");
		for(int i=0;i<1000000;i++){
			Singer singer=bean.getMySinger();
			//singer.sing();
		}
		stopWatch.stop();

		System.out.println("100000 gets took "+stopWatch.getTotalTimeMillis()+" ms");
	}

}
