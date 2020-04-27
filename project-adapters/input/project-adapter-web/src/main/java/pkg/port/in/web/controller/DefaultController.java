package pkg.port.in.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pkg.domain.Message;
import pkg.port.out.SendMessage;

@RestController
@RequestMapping("/message")
public class DefaultController {
	
	private SendMessage service;
	
	@Autowired
	public DefaultController(SendMessage service) {
		this.service = service;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String postMessage(@RequestBody Message message) {
		try {
			service.send(message);
			return "Sucesso";
		} catch (IOException e) {
			return "Erro "+e.getMessage();
		}
	}

}
