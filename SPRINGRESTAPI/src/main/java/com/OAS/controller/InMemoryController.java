package com.OAS.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.OAS.model.Message;

@RestController
public class InMemoryController {
	@RequestMapping("/")
	public ResponseEntity<Message> welcome(HttpServletRequest request) {
		return new ResponseEntity<Message>(new Message("idMatch", "Praveen"), new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Message> welcome1(@RequestBody Message msg) {
		return new ResponseEntity<Message>(new Message(msg.getName(), msg.getText()), new HttpHeaders(), HttpStatus.OK);
	}

}