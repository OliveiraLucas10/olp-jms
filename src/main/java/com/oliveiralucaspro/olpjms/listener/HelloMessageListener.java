package com.oliveiralucaspro.olpjms.listener;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.oliveiralucaspro.olpjms.config.JmsConfig;
import com.oliveiralucaspro.olpjms.model.HelloWorldMessage;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders headers, Message message) {

	// System.out.println("I Got a Message!!!!!");

	// System.out.println(helloWorldMessage);

	/**
	 * If the listener thrown an exception, than the MSQ will update property
	 * "JMSXDeliveryCount", it won't mark this message as delivered
	 */
	// throw new RuntimeException();

    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders headers,
	    Message message) throws JMSException {

	HelloWorldMessage payloadMsg = HelloWorldMessage.builder().id(UUID.randomUUID()).message("World!!").build();

	jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);

    }

}
