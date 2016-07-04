package com.satish.SpringBootBasics.mongodb.repo.seq;

public interface SequenceRepository {
	public static final String ID = "id";
	
	public long getSequenceId(String collectionName);
}
