package com.ups.yams.model.music

import com.ups.yams.repository.AlbumMongoRepository
import com.ups.yams.repository.StyleMongoRepository
import com.ups.yams.repository.TrackMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class AlbumITest extends Specification{
    @Autowired AlbumMongoRepository albumMongoRepository
    @Autowired TrackMongoRepository trackMongoRepository
    @Autowired StyleMongoRepository styleMongoRepository

    def "test save repository"() {
        given: "a track"
        Track track = new Track(name: "track 1", trackNumber: 1, duration: 12)
        Track track2 = new Track(name: "track 2", trackNumber: 2, duration: 12)
        ArrayList<Track> trackList = new ArrayList<>()
        trackList.add(track)
        trackList.add(track2)
        Style style = new Style(name: "groovy", description: "funky style")
        Album album = new Album(
                name: "name",
                releaseDate: new Date(),
                coverPicture: "url",
                duration: 12,
                streamingLink: "urlStreaming",
                tracks: trackList,
                style: style
        )

        when: "the track is saved"
        trackMongoRepository.save(track)
        trackMongoRepository.save(track2)
        styleMongoRepository.save(style)
        albumMongoRepository.save(album)

        then: "the track has an id"
        style.getId() != null
        track.getId() != null
        track2.getId() != null
        album.getId() != null
    }
}
