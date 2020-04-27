package pkg.port.out;

import java.io.IOException;

import pkg.domain.Message;

public interface SendMessage {
	
	public void send(Message message) throws IOException;

}
