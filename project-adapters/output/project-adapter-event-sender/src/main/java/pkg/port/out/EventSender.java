package pkg.port.out;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Qualifier(EventSender.QUALIFIER)
public class EventSender<T> {
	
	public static final String QUALIFIER = "EventSenderType";
	
    private DefaultKafkaProducerFactory<String, T> factory;
	
    @Autowired
    public EventSender(DefaultKafkaProducerFactory<String, T> factory) {
		this.factory = factory;
	}

	public ListenableFuture<SendResult<String, T>> send(T message) throws IOException {
    	return this.messageKafkaTemplate().send("event-name", message);
    }
    
    private KafkaTemplate<String, T> messageKafkaTemplate() {
        return new KafkaTemplate<String, T>(factory);
    }
}
