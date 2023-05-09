package com.test.webprojectapi;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstRestAPI {
	
	@GetMapping("testServer")
	public String sayHelloAPI() {
		return "Server is up and running";
	}
	@GetMapping("getAllStudents")
	public List<Student> getAllStudent(){
		List<Student> students=new LinkedList<>();
		students.add(new Student("101", "Sonu", "Address 1"));
		students.add(new Student("102", "Monu", "Address 1"));
		students.add(new Student("103", "Sumit", "Address 1"));
		students.add(new Student("104", "amit", "Address 1"));
		students.add(new Student("105", "ramit", "Address 1"));
		students.add(new Student("106", "jamit", "Address 1"));
		students.add(new Student("107", "hamit", "Address 1"));
		students.add(new Student("108", "Anit", "Address 1"));
		return students;
	}
	@GetMapping("produce")
	public String produce(){
		Properties prop=new Properties();
		prop.setProperty("bootstrap-servers", "localhost:9092");
		prop.setProperty("kafka.topic.name", "test");
		KafkaProducer<String, byte[]> producer=new KafkaProducer<>(prop, new StringSerializer(),new ByteArraySerializer());
		byte[] payload = ("this is a message callinitiated at  "+new Date()).getBytes();
		ProducerRecord<String, byte[]> record=new ProducerRecord<String, byte[]>(prop.getProperty("kafka.topic.name"), payload);
		producer.send(record);
		return null;
	}

}
