package com.ibm.pnckafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PnckafkaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PnckafkaApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {

	}
}
