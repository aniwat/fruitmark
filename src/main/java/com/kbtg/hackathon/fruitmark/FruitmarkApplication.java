package com.kbtg.hackathon.fruitmark;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FruitmarkApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FruitmarkApplication.class, args);
		
		System.out.println("Inspect the beans provided by Spring Boot:");
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			//System.out.println("Bean Definition Name : " + beanName);
		}
	}
	
}
