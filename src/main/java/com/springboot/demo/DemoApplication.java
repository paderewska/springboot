package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.NumberFormat;
import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public NumberFormat defaultFormatter() {
		return NumberFormat.getCurrencyInstance();
	}

	@Bean
	public NumberFormat germanFormatter() {
		return NumberFormat.getCurrencyInstance(Locale.GERMANY);
	}
}
