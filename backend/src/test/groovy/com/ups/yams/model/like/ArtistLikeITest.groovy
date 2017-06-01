package com.ups.yams.model.like

import com.ups.yams.model.music.Artist
import com.ups.yams.repository.ArtistLikeMongoRepository
import com.ups.yams.repository.ArtistMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class ArtistLikeITest extends Specification {
    @Autowired ArtistLikeMongoRepository artistLikeMongoRepository
    @Autowired ArtistMongoRepository artistMongoRepository

    def "test save repository"() {
        given: "a artistLike"
        Artist artist = new Artist(name: "artist 1", biography: "biography")
        ArtistLike artistLike = new ArtistLike(artist: artist)

        when: "the artistLike is saved"
        artistMongoRepository.save(artist)
        artistLikeMongoRepository.save(artistLike)

        then: "the artist has an id"
        artistLike.getId() != null
    }
}
