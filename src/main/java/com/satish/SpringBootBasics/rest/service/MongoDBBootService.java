package com.satish.SpringBootBasics.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.satish.SpringBootBasics.mongodb.ChatTransaction;
import com.satish.SpringBootBasics.mongodb.Messages;
import com.satish.SpringBootBasics.mongodb.repo.ChatMessagesRepository;

@RestController
@RequestMapping("/chat")
public class MongoDBBootService {

	@Autowired
	ChatMessagesRepository chatRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/new",
			consumes = "application/json", produces = "application/json")
	ChatTransaction CreateNewChat(@RequestBody ChatTransaction ct) {
		ChatTransaction ctNew = chatRepository.save(ct);
		return ctNew;
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/end/{id}")
	String endChat(@PathVariable String id) {
		chatRepository.endChat(id);
		return "Success";
    }
	
	@RequestMapping(method = RequestMethod.POST,  value = "/message/{id}",
			consumes = "application/json", produces = "application/json")
	ChatTransaction addChatMessage(@RequestBody Messages msg,@PathVariable String id) {
		ChatTransaction ctNew = chatRepository.addMessages(msg, id);
		return ctNew;
    }
	
	
	@RequestMapping(method = RequestMethod.GET,  value = "/{id}",
			 produces = "application/json")
	ChatTransaction getChatTransaction(@PathVariable String id) {
		ChatTransaction ctNew = chatRepository.findOne(id);
		return ctNew;
    }
	
	@RequestMapping(method = RequestMethod.GET,  value = "/all",
			 produces = "application/json")
	List<ChatTransaction> getChatTransaction() {
		List<ChatTransaction> ctNew = chatRepository.findAll();
		return ctNew;
   }
	
	
	@RequestMapping(method = RequestMethod.DELETE,  value = "/{id}")
	String DeleteChatTransaction(@PathVariable String id) {
		 chatRepository.delete(id);
		return "success";
   }
}
