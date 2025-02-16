package com.dit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dit.kafka.JSONKafkaProducer;
import com.dit.payload.User;

@RestController
@RequestMapping("/api/json/kafka")
public class JSONMessageController {

	private JSONKafkaProducer jsonKafkaProducer;

	public JSONMessageController(JSONKafkaProducer jsonKafkaProducer) {
		this.jsonKafkaProducer = jsonKafkaProducer;
	}

	@GetMapping("/publish")
	public String publishMessage(@RequestBody User user) {
		jsonKafkaProducer.sendMessage(user);
		return "JSON Message sent";
	}
}
