package com.ups.yams.repository;

import com.ups.yams.model.like.TrackLike;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackLikeMongoRepository extends MongoRepository<TrackLike, String> {
}
