package pkg.port.in.event.listener;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import pkg.domain.Message;

@Service
public class EventListener {
	
	@Autowired
    private ObjectMapper objectMapper;
	
    @KafkaListener(topics = "event-name", groupId = "kafkaGroupId")
    public void listen(String message) throws IOException {
    	Message event = this.objectMapper.readValue(message, Message.class);
    	System.out.println("Evento recebido:>> "+event.toString());
    }
}
