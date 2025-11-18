package com.example.Learner.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Learner.model.Notes;

public interface NoteRepository extends MongoRepository<Notes, String> {
	List<Notes> findByUserId(String userId);

}
