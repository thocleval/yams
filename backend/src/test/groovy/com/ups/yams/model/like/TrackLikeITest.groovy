package com.ups.yams.model.like

import com.ups.yams.model.music.Track
import com.ups.yams.model.like.TrackLike
import com.ups.yams.repository.TrackMongoRepository
import com.ups.yams.repository.TrackLikeMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class TrackLikeITest extends Specification {
    @Autowired TrackLikeMongoRepository trackLikeMongoRepository
    @Autowired TrackMongoRepository trackMongoRepository

    def "test save repository"() {
        given: "a trackLike"
        Track track = new Track(name: "track 1", trackNumber: 1, duration: 12)
        TrackLike trackLike = new TrackLike(track: track)

        when: "the trackLike is saved"
        trackMongoRepository.save(track)
        trackLikeMongoRepository.save(trackLike)

        then: "the track has an id"
        trackLike.getId() != null
    }
}