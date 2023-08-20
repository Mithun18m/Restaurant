package com.mindtree.customer.serviceImplementation;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.mindtree.customer.entity.CustomerEvent;

@Service
public class CustomerProducer
{
	private final Logger log=LoggerFactory.getLogger(CustomerProducer.class);
	private NewTopic newTopic;
	
	//this will sent the messages from the producer to the topic,here string is a key value pair 
	private KafkaTemplate<String,CustomerEvent> kafkaTemplate;

	public CustomerProducer(NewTopic newTopic, KafkaTemplate<String, CustomerEvent> kafkaTemplate) {
		super();
		this.newTopic = newTopic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	//Inthis we have created a send,Message method
	public void sendMesage(CustomerEvent customerEvent)
	{
		log.info(String.format("customer event => %s ",customerEvent.toString()));
		
		//next we will sent a message from kafka template to the topic
		
		//with inthis send message method we have created a message
		Message<CustomerEvent> message=MessageBuilder
				.withPayload(customerEvent)
				.setHeader(KafkaHeaders.TOPIC, newTopic.name())
				.build();
		//and then we use this kafkaTemplate to sent the message to the kafka topic.
		kafkaTemplate.send(message);
		
		//Inthis we have created a send,Message method
	}
	
	

}
