package com.mindtree.review.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mindtree.customer.entity.CustomerEvent;

@Service
public class CustomerConsumer 
{
	private static final Logger log =LoggerFactory.getLogger(CustomerConsumer.class);
	
	@KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
            )
    public void consume(CustomerEvent event) {
        log.info(String.format("Order event recived in review management service => %s", event.toString()));
	}

}
