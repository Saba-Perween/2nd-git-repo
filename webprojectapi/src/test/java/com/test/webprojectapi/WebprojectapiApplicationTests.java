package com.test.webprojectapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebprojectapiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testOne() {
		MyFirstRestAPI api=new MyFirstRestAPI();
		assertEquals(api.sayHelloAPI(), "Server is up and running");
	}
	@Test
	public void testTwo() {
		MyFirstRestAPI api=new MyFirstRestAPI();
		
		List<Student> students=new LinkedList<>();
		students.add(new Student("101", "Sonu", "Address 1"));
		students.add(new Student("102", "Monu", "Address 1"));
		students.add(new Student("103", "Sumit", "Address 1"));
		students.add(new Student("104", "amit", "Address 1"));
		students.add(new Student("105", "ramit", "Address 1"));
		students.add(new Student("106", "jamit", "Address 1"));
		students.add(new Student("107", "hamit", "Address 1"));
		assertEquals(api.getAllStudent().get(0).getAddress(), students.get(0).getAddress());
	}
}
