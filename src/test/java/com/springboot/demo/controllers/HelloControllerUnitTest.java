package com.springboot.demo.controllers;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.Assert.*;

public class HelloControllerUnitTest {

    @Test
    public void testSayHello() {

        //Given
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();

        //When
        String result = controller.sayHello("World", model);

        //Then
        assertEquals("World", model.asMap().get("user"));
        assertEquals("hello", result);
    }

    @Test
    public void testSayHelloWithName() {

        //Given
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();

        //When
        String result = controller.sayHello("Iza", model);

        //Then
        assertEquals("Iza", model.asMap().get("user"));
        assertEquals("hello", result);
    }
}