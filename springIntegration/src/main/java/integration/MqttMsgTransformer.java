package integration;

import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;

public class MqttMsgTransformer implements CustomGateway {

	public String sendMqttMessage(Message<?> paramMessage) {
		System.out.println("started MqttMsgTransformer.transformMsg()");
		String topic = (String) paramMessage.getHeaders().get(MqttHeaders.TOPIC);
		Long timeStamp = paramMessage.getHeaders().getTimestamp();
		System.out.println("Received Message on Topic::::::" + topic + "     with payload.... "
				+ paramMessage.getPayload().toString());
		System.out.println("completed MqttMsgTransformer.transformMsg()");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paramMessage.getPayload().toString() + "TRANSFORMED";
	}
}
