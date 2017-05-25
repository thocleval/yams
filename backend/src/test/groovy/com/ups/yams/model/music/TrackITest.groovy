package com.ups.yams.model.music

import com.ups.yams.repository.TrackMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class TrackITest extends Specification {
    @Autowired TrackMongoRepository trackMongoRepository

    def "test save repository"() {
        given: "a track"
        Track track = new Track(name: "track 1", trackNumber: 1, duration: 12)

        when: "the track is saved"
        trackMongoRepository.save(track)

        then: "the track has an id"
        track.getId() != null
    }
}
