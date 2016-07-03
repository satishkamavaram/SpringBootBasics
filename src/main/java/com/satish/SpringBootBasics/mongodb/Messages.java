package com.satish.SpringBootBasics.mongodb;

public class Messages {

	
	private String from;
	
	private String to;
	
	private String message;

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return String.format("From=%s, To=%s Message=%s",
				this.from,this.to,this.message);
	}
}
