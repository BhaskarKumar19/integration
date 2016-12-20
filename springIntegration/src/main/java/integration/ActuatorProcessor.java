package integration;

import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;

public class ActuatorProcessor {

	public void runProcessor(Message<?> paramMessage) {
		System.out.println("started ActuatorProcessor.runProcessor()");
		String topic = (String) paramMessage.getHeaders().get(MqttHeaders.TOPIC);
		Long timeStamp = paramMessage.getHeaders().getTimestamp();
		System.out.println("Received Message on Topic::::::" + topic + "     with payload.... "
				+ paramMessage.getPayload().toString());
		System.out.println("completed ActuatorProcessor.runProcessor()");
	}
}
