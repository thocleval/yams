package com.ups.yams.repository;

import com.ups.yams.model.like.AlbumLike;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumLikeMongoRepository extends MongoRepository<AlbumLike, String> {
}
