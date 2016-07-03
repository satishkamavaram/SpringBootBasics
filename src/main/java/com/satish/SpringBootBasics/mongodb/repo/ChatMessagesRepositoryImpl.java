package com.satish.SpringBootBasics.mongodb.repo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.satish.SpringBootBasics.mongodb.ChatTransaction;
import com.satish.SpringBootBasics.mongodb.Messages;

public class ChatMessagesRepositoryImpl implements CustomChatMessagesRepository {

	@Autowired
	MongoOperations operations;

	/**
	 * 
	 * @param message
	 * @param id
	 */
	public ChatTransaction addMessages(Messages message,String id) {
	  operations.updateFirst(new Query(Criteria.where("id").is(id)),
				new Update().push("messages",message), 
				ChatTransaction.class);
	 return operations.findOne(new Query(Criteria.where("id").is(id)), ChatTransaction.class);
	}
	
	/**
	 * 
	 */
	public void endChat(String id) {
		 operations.updateFirst(new Query(Criteria.where("id").is(id)),new Update().set("chatEndTime", new Date()),ChatTransaction.class);
	}
	
}
