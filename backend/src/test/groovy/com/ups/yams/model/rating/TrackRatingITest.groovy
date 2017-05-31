package com.ups.yams.model.rating

import com.ups.yams.model.music.Track
import com.ups.yams.model.rating.TrackRating
import com.ups.yams.repository.TrackMongoRepository
import com.ups.yams.repository.TrackRatingMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class TrackRatingITest extends Specification {
    @Autowired TrackRatingMongoRepository trackRatingMongoRepository
    @Autowired TrackMongoRepository trackMongoRepository

    def "test save repository"() {
        given: "a trackRating"
        Track track = new Track(name: "track 1", trackNumber: 1, duration: 12)
        TrackRating trackRating = new TrackRating(track: track, value: 3)

        when: "the trackRating is saved"
        trackMongoRepository.save(track)
        trackRatingMongoRepository.save(trackRating)

        then: "the track has an id"
        trackRating.getId() != null
    }
}