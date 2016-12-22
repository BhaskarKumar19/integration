package integration;
import org.springframework.messaging.Message;

public interface CustomGateway {
	String sendMqttMessage(Message<?> msg);
}
