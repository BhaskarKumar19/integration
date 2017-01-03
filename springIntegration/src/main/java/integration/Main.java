package integration;

import java.util.concurrent.Future;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

public class Main {

	public static void main(String[] args) throws Throwable {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("simple-integration.xml");
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
		
		
		
		MqttPahoMessageDrivenChannelAdapter messageChannelAdaptor;
		messageChannelAdaptor=context.getBean("mqttInboundAdapter",MqttPahoMessageDrivenChannelAdapter.class);
		messageChannelAdaptor.addTopic("test2/integrationTest/SENSOR");
		
		CustomGateway gatewayService;
		gatewayService= context.getBean("customGatewayService", CustomGateway.class);
		
		
		@SuppressWarnings("rawtypes")
		Message m= MessageBuilder.withPayload("DYNAMIC PAYLOAD!")
				.setHeader(MqttHeaders.TOPIC, "test2/integrationTest/SENSOR").build();
		
		@SuppressWarnings("rawtypes")
		Future resp=gatewayService.sendMqttMessage(m);
		
		while (!resp.isDone()) {
			System.out.println("Task is not completed yet....");
			Thread.sleep(500);
		}
		System.out.println("Task is completed !!.");
		System.out.println(resp.get());
			
		context.close();
	}

}
