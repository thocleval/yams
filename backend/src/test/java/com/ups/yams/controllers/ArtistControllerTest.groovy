package com.ups.yams.controllers

import com.ups.yams.model.Artist
import com.ups.yams.repository.ArtistMongoRepository
import spock.lang.Specification

class ArtistControllerTest extends Specification {
    ArtistMongoRepository artistMongoRepositoryMock;
    ArtistController artistController;

    void setup() {
        artistMongoRepositoryMock = Mock()
        artistController = new ArtistController(artistMongoRepository: artistMongoRepositoryMock)
    }

    def "test artist getters"(String name, String biography, String urlImage) {
        given: "un artistecontroller"
        Artist artist = new Artist(name: name, biography: biography, url: urlImage)

        when:
        artistController.addArtist(artist)

        then: "les getters de l'artiste renvoient les bonnes valeurs"
        1 * artistMongoRepositoryMock.save(artist)

        where:
        name    | biography     | urlImage
        "name2" | "bio 2"       | "url"
    }
}
