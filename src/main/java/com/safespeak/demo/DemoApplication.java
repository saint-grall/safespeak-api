package com.safespeak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


import java.util.logging.Logger;

@EnableScheduling
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DemoApplication {

	private static final Logger logger = Logger.getLogger(DemoApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.info("--------------------------    SafeSpeak API START    --------------------------");
	}
}
