package com.ups.yams.repository;

import com.ups.yams.model.UserDataObject;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserMongoRepository extends MongoRepository<UserDataObject, String> {
}
