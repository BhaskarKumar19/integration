package integration;

import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;

public class CustomRouter {

	public String route(Message<?> arg0) {
		System.out.println("Router invoked");
		String topic = (String) arg0.getHeaders().get(MqttHeaders.TOPIC);

		if (topic != null && topic.equalsIgnoreCase("test2/integrationTest/SENSOR")) {
			return "sensorChannel";
		} else if (topic != null && topic.equalsIgnoreCase("test2/integrationTest/ACTUATOR")) {
			return "actuatorChannel";
		}
		return null;
	}

}
