package it.gpedulla.serviceA.model;

public class Payload<T> {

	private T payload;
	
	private String message;

	public T getPayload() {
		return payload;
	}

	
	public Payload(T payload, String message) {
		super();
		this.payload = payload;
		this.message = message;
	}

	/*
	 * ==========================================================
	 * ==========================================================
	 * ============ 		GETTER E STTER   ==================== 
	 * ==========================================================
	 * ==========================================================
	 */
	public void setPayload(T payload) {
		this.payload = payload;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Payload [payload=" + payload + ", message=" + message + "]";
	}
}
