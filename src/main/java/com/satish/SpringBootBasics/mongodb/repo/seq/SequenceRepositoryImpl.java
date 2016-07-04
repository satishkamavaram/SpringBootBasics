package com.satish.SpringBootBasics.mongodb.repo.seq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.satish.SpringBootBasics.mongodb.Sequence;

@Service
public class SequenceRepositoryImpl implements SequenceRepository {

	@Autowired
	MongoOperations operations;

	@Override
	public long getSequenceId(String collectionName) {
		Sequence sequence =	operations.findAndModify(new Query(Criteria.where(ID).is(collectionName)), 
				new Update().inc("seq", 1),
				Sequence.class);
		return sequence.getSequenceId();
	}

}
