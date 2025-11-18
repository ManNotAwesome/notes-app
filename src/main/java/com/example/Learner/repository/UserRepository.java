package com.example.Learner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Learner.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

}
