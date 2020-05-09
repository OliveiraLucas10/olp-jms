package com.oliveiralucaspro.olpjms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.oliveiralucaspro.olpjms.config.JmsConfig;
import com.oliveiralucaspro.olpjms.model.HelloWorldMessage;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders header, Message message) {

	System.out.println("I Got a Message!!!");

	System.out.println(helloWorldMessage);

	/**
	 * If the listener thrown an exception, than the MSQ will update property
	 * "JMSXDeliveryCount", it won't mark this message as delivered
	 */
	//	throw new RuntimeException();

    }

}
