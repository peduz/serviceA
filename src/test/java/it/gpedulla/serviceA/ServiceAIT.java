package it.gpedulla.serviceA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.gpedulla.serviceA.model.Payload;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceAIT {

	 @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    public void testCallServiceB() {
	        // Definisci l'URL relativo per il servizio A che deve chiamare ServiceB
	        String url = "http://localhost:8080/serviceA/serviceb";
	        
	        // Prepara l'header e il corpo della richiesta (se necessario)
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity<String> entity = new HttpEntity<>(null, headers);

	        // Esegui la chiamata POST per il test
	        ResponseEntity<Payload> response = restTemplate.exchange(url, HttpMethod.GET, entity, Payload.class);

	        // Verifica che la chiamata abbia avuto successo
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertNotNull(response.getBody());
	        assertEquals("{\"payload\":\"Message received: Hello from Service A!\",\"message\":\"ok\"}", response.getBody().getPayload());
	    }
}

