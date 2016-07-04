package com.satish.SpringBootBasics.util;

public class ApplicationConstants {

	public static final String CHAT_URI="/chat";
	public static final String ID_TRANS_URI="/{id}";
	public static final String CREATE_NEW_CHAT_TRANS_URI="/new";
	public static final String END_CHAT_TRANS_URI="/end"+ID_TRANS_URI;
	public static final String ADD_CHAT_MESSAGE_URI="/message"+ID_TRANS_URI;;
	public static final String ALL_CHAT_TRANS_URI="/all";
	public static final String GET_CHAT_INITIATOR_URI="/initiator/{initiator}";
	public static final String COUNT_CHAT_INITIATOR_URI="/initiator/count/{initiator}";
	
	public static final String SUCCESS="SUCCESS";
}
