package com.ups.yams.repository;

import com.ups.yams.model.rating.TrackRating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackRatingMongoRepository extends MongoRepository<TrackRating, String> {
}
