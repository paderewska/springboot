package com.springboot.demo.config;

import com.springboot.demo.entities.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.NumberFormat;
import java.util.Locale;

@Configuration
public class AppConfig {

    @Bean
    public NumberFormat defaultFormatter() {
        return NumberFormat.getCurrencyInstance();
    }

    @Bean
    public NumberFormat germanFormatter() {
        return NumberFormat.getCurrencyInstance(Locale.GERMANY);
    }

    @Bean("helloGreeting")
    public Greeting getHelloGreeting() {
        return new Greeting("Hello, World!");
    }

}
