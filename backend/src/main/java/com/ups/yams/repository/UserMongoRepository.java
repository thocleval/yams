package com.ups.yams.repository;

import com.ups.yams.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserMongoRepository extends MongoRepository<User, String> {
}
