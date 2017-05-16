package com.ups.yams.repository;

import com.ups.yams.model.Nationality;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NationalityMongoRepository extends MongoRepository<Nationality, String> {
}
