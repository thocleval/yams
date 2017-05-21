package com.ups.yams.repository;

import com.ups.yams.model.music.Track;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TrackMongoRepository extends MongoRepository<Track, String> {
}