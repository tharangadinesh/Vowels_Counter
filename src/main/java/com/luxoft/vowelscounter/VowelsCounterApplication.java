package com.luxoft.vowelscounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.luxoft.vowelscounter.counter.VowelCounter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.luxoft.vowelscounter.service", "com.luxoft.vowelscounter.reader", "com.luxoft.vowelscounter.writer", "com.luxoft.vowelscounter.counter"})
public class VowelsCounterApplication implements CommandLineRunner{

	@Autowired
	VowelCounter counter;

	public static void main(String[] args) {
		SpringApplication.run(VowelsCounterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {
			counter.count(args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
