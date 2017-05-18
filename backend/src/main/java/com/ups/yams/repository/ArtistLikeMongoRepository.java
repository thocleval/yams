package com.ups.yams.repository;

import com.ups.yams.model.ArtistLike;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistLikeMongoRepository extends MongoRepository<ArtistLike, String> {
}
