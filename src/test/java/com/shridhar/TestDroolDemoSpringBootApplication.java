package com.shridhar;

import org.springframework.boot.SpringApplication;

public class TestDroolDemoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.from(DroolDemoSpringBootApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
