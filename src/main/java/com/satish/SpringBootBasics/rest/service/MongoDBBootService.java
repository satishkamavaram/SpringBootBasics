package com.satish.SpringBootBasics.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.satish.SpringBootBasics.mongodb.ChatTransaction;
import com.satish.SpringBootBasics.mongodb.Messages;
import com.satish.SpringBootBasics.mongodb.repo.ChatMessagesRepository;
import static com.satish.SpringBootBasics.util.ApplicationConstants.*;


@RestController
@RequestMapping(CHAT_URI)
public class MongoDBBootService {

	
	@Autowired
	ChatMessagesRepository chatRepository;

	@RequestMapping(method = RequestMethod.POST, value = CREATE_NEW_CHAT_TRANS_URI,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ChatTransaction CreateNewChat(@RequestBody ChatTransaction ct) {
		ChatTransaction ctNew = chatRepository.save(ct);
		return ctNew;
    }
	
	@RequestMapping(method = RequestMethod.GET, value = END_CHAT_TRANS_URI)
	String endChat(@PathVariable String id) {
		chatRepository.endChat(id);
		return SUCCESS;
    }
	
	@RequestMapping(method = RequestMethod.POST,  value = ADD_CHAT_MESSAGE_URI,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ChatTransaction addChatMessage(@RequestBody Messages msg,@PathVariable String id) {
		ChatTransaction ctNew = chatRepository.addMessages(msg, id);
		return ctNew;
    }
	
	
	@RequestMapping(method = RequestMethod.GET,  value = ID_TRANS_URI,
			 produces = MediaType.APPLICATION_JSON_VALUE)
	ChatTransaction getChatTransaction(@PathVariable String id) {
		ChatTransaction ctNew = chatRepository.findOne(id);
		return ctNew;
    }
	
	@RequestMapping(method = RequestMethod.GET,  value = GET_ALL_CHAT_TRANS_URI,
			 produces = MediaType.APPLICATION_JSON_VALUE)
	List<ChatTransaction> getAllChatTransactions() {
		List<ChatTransaction> ctNew = chatRepository.findAll();
		return ctNew;
   }
	
	@RequestMapping(method = RequestMethod.GET,  value = GET_CHAT_INITIATOR_URI,
			 produces = MediaType.APPLICATION_JSON_VALUE)
	List<ChatTransaction> getInitiatorForAllChatTransactions(@PathVariable String initiator) {
		List<ChatTransaction> ctNew = chatRepository.findByInitiator(initiator);
		return ctNew;
  }
	
	@RequestMapping(method = RequestMethod.GET,  value = COUNT_CHAT_INITIATOR_URI,
			 produces = MediaType.APPLICATION_JSON_VALUE)
	Long countInitiatorForAllChatTransactions(@PathVariable String initiator) {
		return chatRepository.countByInitiator(initiator);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,  value = ID_TRANS_URI)
	String deleteChatTransaction(@PathVariable String id) {
		 chatRepository.delete(id);
		return SUCCESS;
   }
}
