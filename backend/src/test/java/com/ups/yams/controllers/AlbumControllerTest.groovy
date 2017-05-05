package com.ups.yams.controllers

import com.ups.yams.model.Album
import com.ups.yams.repository.AlbumMongoRepository
import spock.lang.Specification

class AlbumControllerTest extends Specification {
    AlbumMongoRepository albumMongoRepositoryMock;
    AlbumController albumController;

    void setup() {
        albumMongoRepositoryMock = Mock()
        albumController = new AlbumController(albumMongoRepository: albumMongoRepositoryMock)
    }

    def "test album getters"(String aName, Date aDate, String aCoverPicture, int aDuration, String aStreamingLink) {
        given: "un albumcontroller"
        Album album = new Album(name: aName, releaseDate: aDate, coverPicture: aCoverPicture, duration: aDuration, streamingLink: aStreamingLink)

        when:
        albumController.addAlbum(album)

        then: "les getters de l'album renvoient les bonnes valeurs"
        1 * albumMongoRepositoryMock.save(album)

        where:
        aName        | aDate     | aCoverPicture         | aDuration     | aStreamingLink
        "AlbumName"  |new Date() | "coverPicture.jpg"    | 180           | "deezer.com"
    }
}
