package com.ups.yams.repository;

import com.ups.yams.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface AlbumMongoRepository extends MongoRepository<Album, String> {
}
