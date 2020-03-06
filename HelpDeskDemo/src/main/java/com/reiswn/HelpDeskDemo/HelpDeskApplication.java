package com.reiswn.HelpDeskDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.reiswn.HelpDeskDemo.models.User;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = User.class)
public class HelpDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

}
