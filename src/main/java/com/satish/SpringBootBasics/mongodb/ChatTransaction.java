package com.satish.SpringBootBasics.mongodb;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="chatTransaction")
public class ChatTransaction {
	
	@Id
	private Long id;
	
	@Field("initiator")
	private String initiator;
	
	@Field("startTime")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date chatStartTime;
	
	@Field("endTime")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date chatEndTime;
	
	@Field("messages")
	private List<Messages> messages;

	public  ChatTransaction() {
		this.chatStartTime = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setChatStartTime(Date chatStartTime) {
		this.chatStartTime = chatStartTime;
	}

	public void setChatEndTime() {
		this.chatEndTime = new Date();
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	
	public void addMessage(Messages msg){
		this.messages.add(msg);
	}

	public Date getChatStartTime() {
		return chatStartTime;
	}

	public Date getChatEndTime() {
		return chatEndTime;
	}

	public List<Messages> getMessages() {
		return messages;
	}
	
	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	
	@Override
	public String toString() {
		return String.format("Id=%s, StartTime=%s EndTime=%s Messages=%s",
				this.id,this.chatStartTime,this.chatEndTime,this.messages);
	}
}
