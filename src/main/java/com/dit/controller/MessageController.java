package com.dit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dit.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {

	private KafkaProducer kafkaProducer;
	
	public MessageController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@GetMapping("/publish")
	public String publishMessage(@RequestParam String message) {
		kafkaProducer.sendMessage(message);
		return "Message sent";		
	}
}
