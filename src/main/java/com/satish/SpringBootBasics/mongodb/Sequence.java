package com.satish.SpringBootBasics.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="sequence")
public class Sequence {
	
	
	@Id
	private String id;
	
	@Field("seq")
	private long sequenceId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(long sequenceId) {
		this.sequenceId = sequenceId;
	}

	

}
