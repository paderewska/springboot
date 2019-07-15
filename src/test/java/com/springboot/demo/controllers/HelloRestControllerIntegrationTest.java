package com.springboot.demo.controllers;

import com.springboot.demo.entities.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerIntegrationTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void greetWithoutName() {

        //Given
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);

        //When
        Greeting response = entity.getBody();

        //Then
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, entity.getHeaders().getContentType());
        assertEquals("Hola, World!", response.getGreeting());
    }

    @Test
    public void greetWithName() {

        //Given
        Greeting response = template.getForObject("/rest?=name=Iza", Greeting.class);

        //Then
        assertEquals("Hola, Iza!", response.getGreeting());
    }
}