package com.satish.SpringBootBasics.mongodb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satish.SpringBootBasics.mongodb.ChatTransaction;

public interface ChatMessagesRepository extends MongoRepository<ChatTransaction, String>,CustomChatMessagesRepository {

	
	
}
