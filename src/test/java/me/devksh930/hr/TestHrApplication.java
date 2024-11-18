package me.devksh930.hr;

import org.springframework.boot.SpringApplication;

public class TestHrApplication {

	public static void main(String[] args) {
		SpringApplication.from(HrApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
