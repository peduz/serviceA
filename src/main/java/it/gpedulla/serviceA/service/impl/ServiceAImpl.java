package it.gpedulla.serviceA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.gpedulla.serviceA.service.ServiceA;

@Service
public class ServiceAImpl implements ServiceA {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${service-a.url.service-b.baseUrl}")
	private String serviceBBaseUrl;
	
	@Value("${service-a.url.service-b.receive}")
	private String serviceBReceiveUrl;
	
	@Override
	public String reply(String name) {

		if (name == null || name.isBlank()) {
			name = "guest";
		}

		return "Hello " + name + " from service a.";
	}


	@Override
	public String callServiceB() throws Exception {
		try {
			String serviceBUrl = serviceBBaseUrl + serviceBReceiveUrl;
			String message = "Hello from Service A!";
			ResponseEntity<String> response = restTemplate.postForEntity(serviceBUrl, message, String.class);

			return response.getBody();
		} catch (Exception e) {
			throw new Exception("Error calling service B " + e.getMessage());
		}
	}
}
