package com.ups.yams.repository;

import com.ups.yams.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ArtistMongoRepository extends MongoRepository<Artist, String> {
}
