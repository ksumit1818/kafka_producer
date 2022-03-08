package com.example.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaproducer.model.User;

@RestController
public class Controller {
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	private static final String TOPIC = "Kafka_Example";

	
	
	@GetMapping("/kafka/{name}")
	public String post(@PathVariable final String name) {
	
		kafkaTemplate.send(TOPIC, new User(name,"Tech",20000L));
		return "msg posted";
	} 
}
