package it.gpedulla.serviceA.service;

public interface ServiceA {
	
	public String reply(String name);
	
	public String callServiceB() throws Exception;
}
