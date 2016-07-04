package com.satish.SpringBootBasics.mongodb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satish.SpringBootBasics.mongodb.ChatTransaction;

public interface ChatMessagesRepository extends MongoRepository<ChatTransaction, String>,CustomChatMessagesRepository {

	public List<ChatTransaction> findByInitiator(String initiator);
	
	public Long countByInitiator(String initiator);
	
}
