package com.ups.yams.repository;

import com.ups.yams.model.rating.AlbumRating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRatingMongoRepository extends MongoRepository<AlbumRating, String> {
}
