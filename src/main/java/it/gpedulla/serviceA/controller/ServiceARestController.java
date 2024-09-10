package it.gpedulla.serviceA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.gpedulla.serviceA.model.Payload;
import it.gpedulla.serviceA.service.ServiceA;

@RestController
@RequestMapping("/serviceA")
public class ServiceARestController {

	@Autowired
	private ServiceA service;

	@GetMapping("/")
	public ResponseEntity<Payload<String>> reply(@RequestParam(required = false) String name) {

		try {	
			return ResponseEntity.ok(new Payload<String>(service.reply(name), "ok"));
		} catch (Exception e) {
			return new ResponseEntity<>(
					new Payload<>(null, "Error: " + e.getMessage()),//Body
					HttpStatus.INTERNAL_SERVER_ERROR);//Response code
		}

	}
	
	@GetMapping("/serviceb")
	public ResponseEntity<Payload<String>> callServiceB() {
		
		try {	
			return ResponseEntity.ok(new Payload<String>(service.callServiceB(), "ok"));
		} catch (Exception e) {
			return new ResponseEntity<>(
					new Payload<>(null, "Error: " + e.getMessage()),//Body
					HttpStatus.INTERNAL_SERVER_ERROR);//Response code
		}
		
	}
}
