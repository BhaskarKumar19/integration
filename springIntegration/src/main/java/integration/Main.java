package integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

public class Main {

	public static void main(String[] args) throws Throwable {
		ApplicationContext context = new ClassPathXmlApplicationContext("simple-integration.xml");
		MessageChannel messageChannel;
		messageChannel = context.getBean("messageChannel2", MessageChannel.class);
		for (int i = 0; i < 5; i++) {
			Thread.sleep(200);
			System.out.println("sending message");
			messageChannel.send(MessageBuilder.withPayload("Josh and Andy say hi!".getBytes())
					.setHeader(MqttHeaders.TOPIC, "testHeaderTopic").build());
			System.out.println("message sent");
		}
	}

}
