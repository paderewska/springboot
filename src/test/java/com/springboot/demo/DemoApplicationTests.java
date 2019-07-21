package com.springboot.demo;

import com.springboot.demo.entities.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Autowired @Qualifier("defaultFormatter")
	private NumberFormat nf;

	@Autowired @Qualifier("germanFormatter")
	private NumberFormat gf;

	@Autowired @Qualifier("greeting")
	private Greeting myGreeting;

	@Test
	public void contextLoads() {
		int count = context.getBeanDefinitionCount();
		String[] names = context.getBeanDefinitionNames();
		System.out.println("There are " + count + " beans in the application");
//		for (String name : context.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
		List<String> nameList = Arrays.stream(names)
				.collect(Collectors.toList());
		assertTrue(nameList.contains("defaultFormatter"));
	}

	@Test
	public void defaultCurrency() {
		System.out.println(nf.format(1234567.8901234));
	}

	@Test
	public void germanCurrency() {

		NumberFormat germanFormatter = context.getBean("germanFormatter", NumberFormat.class);
		System.out.println(germanFormatter.format(1234567.8901234));
		System.out.println(gf.format(1234567.8901234));
	}

	@Test
	public void singletonTest() {
		Greeting greeting1 = context.getBean("greeting", Greeting.class);
		Greeting greeting2 = context.getBean("greeting", Greeting.class);

		greeting1.setGreeting("What up?");
		assertEquals("What up?", greeting2.getGreeting());
		assertTrue(greeting1 == greeting2);
	}

	@Test
	public void checkHelloGreeting() {
		Greeting greeting = context.getBean("helloGreeting", Greeting.class);
		assertEquals("Hello, World!", greeting.getGreeting());
	}

}
