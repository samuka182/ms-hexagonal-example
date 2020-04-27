package pkg.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pkg.domain.Message;
import pkg.port.out.EventSender;
import pkg.port.out.SendMessage;

@Component
class SendMessageService implements SendMessage {
	
	private EventSender<Message> sender;
	
	@Autowired
	public SendMessageService(EventSender<Message> sender) {
		this.sender = sender;
	}

	@Override
	public void send(Message message) throws IOException {
		this.sender.send(message);
	}

}
