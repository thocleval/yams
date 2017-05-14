package com.ups.yams.repository;

import com.ups.yams.model.Style;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StyleMongoRepository extends MongoRepository<Style, String> {
}
