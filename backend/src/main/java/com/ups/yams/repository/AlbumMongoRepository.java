package com.ups.yams.repository;

import com.ups.yams.model.music.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumMongoRepository extends MongoRepository<Album, String> {
}
