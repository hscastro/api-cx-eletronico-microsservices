package com.hscastro.messages;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hscastro.entities.Cliente;

@Component
public class ClienteSendMessage {

	@Value("${beneficiario.rabbitmq.exchange}")
	String exchange;
	
	@Value("${beneficiario.rabbitmq.routingKey}")
	String routingKey;
	
	
	public final RabbitTemplate rabbitTemplate;
	
	@Autowired
	public ClienteSendMessage(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(Cliente cliente) {
		this.rabbitTemplate.convertAndSend(exchange, routingKey, cliente);
	}
		
}
