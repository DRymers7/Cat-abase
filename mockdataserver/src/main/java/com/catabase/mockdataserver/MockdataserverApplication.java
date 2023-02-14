package com.catabase.mockdataserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockdataserverApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(MockdataserverApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MockdataserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Beginning application at " + System.currentTimeMillis());
	}
}
