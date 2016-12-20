package integration;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;

public class MqttSendingMessageHandler extends AbstractMessageHandler{

	@Override
	protected void handleMessageInternal(Message<?> paramMessage) throws Exception {
		// TODO Auto-generated method stub
		String topic= (String)paramMessage.getHeaders().get(MqttHeaders.TOPIC);
		Long timeStamp=paramMessage.getHeaders().getTimestamp();
		System.out.println("Received Message on Topic::::::test"+ topic  +"     with payload.... "+paramMessage.getPayload().toString());
	}

}
