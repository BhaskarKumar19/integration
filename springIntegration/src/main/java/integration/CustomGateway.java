package integration;
import java.util.concurrent.Future;

import org.springframework.messaging.Message;

public interface CustomGateway {
	Future<String> sendMqttMessage(Message<?> msg);
}
