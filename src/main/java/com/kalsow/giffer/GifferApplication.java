package com.kalsow.giffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kalsow")
public class GifferApplication {

	public static void main(String[] args) {
	    System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication.run(GifferApplication.class, args);
	}

}
