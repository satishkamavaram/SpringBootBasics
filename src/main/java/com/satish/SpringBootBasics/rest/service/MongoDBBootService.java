package com.satish.SpringBootBasics.rest.service;

import static com.satish.SpringBootBasics.util.ApplicationConstants.ADD_CHAT_MESSAGE_URI;
import static com.satish.SpringBootBasics.util.ApplicationConstants.CHAT_URI;
import static com.satish.SpringBootBasics.util.ApplicationConstants.COUNT_CHAT_INITIATOR_URI;
import static com.satish.SpringBootBasics.util.ApplicationConstants.CREATE_NEW_CHAT_TRANS_URI;
import static com.satish.SpringBootBasics.util.ApplicationConstants.END_CHAT_TRANS_URI;
import static com.satish.SpringBootBasics.util.ApplicationConstants.ALL_CHAT_TRANS_URI;
import static com.satish.SpringBootBasics.util.ApplicationConstants.GET_CHAT_INITIATOR_URI;
import static com.satish.SpringBootBasics.util.ApplicationConstants.ID_TRANS_URI;
import static com.satish.SpringBootBasics.util.ApplicationConstants.SUCCESS;

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
import com.satish.SpringBootBasics.mongodb.repo.seq.SequenceRepository;


@RestController
@RequestMapping(CHAT_URI)
public class MongoDBBootService {

	private static final String CHAT_INTERACTION_SEQ_KEY = "chatTransaction";
	
	@Autowired
	ChatMessagesRepository chatRepository;

	@Autowired
	SequenceRepository sequenceRepository;
	
	@RequestMapping(method = RequestMethod.POST, value = CREATE_NEW_CHAT_TRANS_URI,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ChatTransaction createNewChat(@RequestBody ChatTransaction ct) {
		ct.setId(sequenceRepository.getSequenceId(CHAT_INTERACTION_SEQ_KEY));
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
	
	@RequestMapping(method = RequestMethod.GET,  value = ALL_CHAT_TRANS_URI,
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
	
	@RequestMapping(method = RequestMethod.DELETE,  value = ALL_CHAT_TRANS_URI)
	String deleteAll() {
		 chatRepository.deleteAll();
		return SUCCESS;
   }
}
