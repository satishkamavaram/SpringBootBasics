package com.satish.SpringBootBasics.mongodb.repo;

import com.satish.SpringBootBasics.mongodb.ChatTransaction;
import com.satish.SpringBootBasics.mongodb.Messages;

public interface CustomChatMessagesRepository {

	public static final String ID = "id";
	public static final String MESSAGES ="messages";
	public static final String CHAT_END_TIME = "chatEndTime";
	
	public ChatTransaction addMessages(Messages messages,String id) ;
	
	public void endChat(String id);
}
