package com.dit.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dit.payload.User;

@Service
public class JSONKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaConsumer.class);

	@KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(User user) {
		LOGGER.info(String.format("Message received -> : %s", user));
	}

}
