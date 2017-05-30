package com.ups.yams.model.rating

import com.ups.yams.model.music.Album
import com.ups.yams.repository.AlbumMongoRepository
import com.ups.yams.repository.AlbumRatingMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class AlbumRatingITest extends Specification {
    @Autowired AlbumRatingMongoRepository albumRatingMongoRepository
    @Autowired AlbumMongoRepository albumMongoRepository

    def "test save repository"() {
        given: "a albumRating"
        Album album = new Album(name: "album 1", releaseDate: new Date(), duration: 12)
        AlbumRating albumRating = new AlbumRating(album: album, value: 3)

        when: "the albumRating is saved"
        albumMongoRepository.save(album)
        albumRatingMongoRepository.save(albumRating)

        then: "the album has an id"
        albumRating.getId() != null
    }
}