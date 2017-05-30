package com.ups.yams.model.like

import com.ups.yams.model.music.Album
import com.ups.yams.repository.AlbumMongoRepository
import com.ups.yams.repository.AlbumLikeMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class AlbumLikeITest extends Specification {
    @Autowired AlbumLikeMongoRepository albumLikeMongoRepository
    @Autowired AlbumMongoRepository albumMongoRepository

    def "test save repository"() {
        given: "a albumLike"
        Album album = new Album(name: "album 1", releaseDate: new Date(), duration: 12)
        AlbumLike albumLike = new AlbumLike(album: album)

        when: "the albumLike is saved"
        albumMongoRepository.save(album)
        albumLikeMongoRepository.save(albumLike)

        then: "the album has an id"
        albumLike.getId() != null
    }
}