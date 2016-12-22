package integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class Main {

	public static void main(String[] args) throws Throwable {
		ApplicationContext context = new ClassPathXmlApplicationContext("simple-integration.xml");
	/*	MessageChannel messageChannel;
		messageChannel = context.getBean("messageChannel2", MessageChannel.class);
		for (int i = 0; i < 5; i++) {
			Thread.sleep(200);

			if (i % 2 == 0) {
				System.out.println("sending message");
				messageChannel.send(MessageBuilder.withPayload("MQTT TEST PAYLOAD!".getBytes())
						.setHeader(MqttHeaders.TOPIC, "test2/integrationTest/SENSOR").build());
				System.out.println("message sent");
			}
			
			else {
				System.out.println("sending message");
				messageChannel.send(MessageBuilder.withPayload("MQTT TEST PAYLOAD!".getBytes())
						.setHeader(MqttHeaders.TOPIC, "test2/integrationTest/ACTUATOR").build());
				System.out.println("message sent");
			}
		}    */
		
		CustomGateway gatewayService;
		gatewayService= context.getBean("customGatewayService", CustomGateway.class);
		String resp=gatewayService.sendMqttMessage(MessageBuilder.withPayload("MQTT TEST PAYLOAD!").build());
		System.out.println(resp);
	}

}
