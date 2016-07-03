package com.satish.SpringBootBasics.mongodb.repo;

import com.satish.SpringBootBasics.mongodb.ChatTransaction;
import com.satish.SpringBootBasics.mongodb.Messages;

public interface CustomChatMessagesRepository {

	public ChatTransaction addMessages(Messages messages,String id) ;
	
	public void endChat(String id);
}
