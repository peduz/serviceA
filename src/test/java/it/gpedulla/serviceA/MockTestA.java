package it.gpedulla.serviceA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import it.gpedulla.serviceA.service.impl.ServiceAImpl;

public class MockTestA {

	@Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ServiceAImpl serviceA;

    public MockTestA() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCallServiceB() throws Exception {
        String expectedResponse = "Hello from Service B!";
        when(restTemplate.postForEntity(anyString(), any(), eq(String.class)))
            .thenReturn(ResponseEntity.ok(expectedResponse));

        String result = serviceA.callServiceB();
        assertEquals(expectedResponse, result);
    }

    @Test
    public void testCallServiceB_Exception() {
        when(restTemplate.postForEntity(anyString(), any(), eq(String.class)))
            .thenThrow(new RuntimeException("Connection error"));

        Exception exception = assertThrows(Exception.class, () -> {
            serviceA.callServiceB();
        });

        assertTrue(exception.getMessage().contains("Error calling service B"));
    }
}