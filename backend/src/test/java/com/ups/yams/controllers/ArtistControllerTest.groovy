package com.ups.yams.controllers

import com.ups.yams.model.Artist
import com.ups.yams.repository.ArtistMongoRepository
import spock.lang.Specification

class ArtistControllerTest extends Specification {
    ArtistMongoRepository artistMongoRepositoryMock
    ArtistController artistController
    Artist artistMock

    void setup() {
        artistMock = Mock(Artist)
        artistMongoRepositoryMock = Mock(ArtistMongoRepository)

        artistController = new ArtistController(artistMongoRepository: artistMongoRepositoryMock)
    }

    def "test add artist"(String name, String biography, String urlImage) {
        given: "un artiste"
        Artist artist = new Artist(name: name, biography: biography, url: urlImage)

        when:
        artistController.addArtist(artist)

        then: "l'artiste doit etre sauvegarde"
        1 * artistMongoRepositoryMock.save(artist)

        where:
        name    | biography     | urlImage
        "name2" | "bio 2"       | "url"
    }

    def "test delete artist"() {
        given: "un id"
        String id = "id"

        when:
        artistController.deleteArtist(id)

        then: "les methodes sont bien appelees"
        1 * artistMongoRepositoryMock.findOne(id) >> artistMock
        1 * artistMongoRepositoryMock.delete(artistMock)
    }


    def "test update existing artist"(String name, String biography, String urlImage) {
        given: "un artiste"
        Artist artist = new Artist(id: "0", name: name, biography: biography, url: urlImage)

        when:
        artistController.updateArtist("0", artist)

        then: "les methodes sont bien appelees"
        1 * artistMongoRepositoryMock.exists("0") >> true
        1 * artistMongoRepositoryMock.save(artist)

        where:
        name    | biography     | urlImage
        "name2" | "bio 2"       | "url"
    }

    def "test update non existing artist"(String name, String biography, String urlImage) {
        given: "un artiste"
        Artist artist = new Artist(id: "1", name: name, biography: biography, url: urlImage)

        when:
        artistController.updateArtist("1", artist)

        then: "les methodes sont bien appelees"
        1 * artistMongoRepositoryMock.exists("1") >> false
        0 * artistMongoRepositoryMock.save(artist)

        where:
        name    | biography     | urlImage
        "name2" | "bio 2"       | "url"
    }

    def "test get artist"() {
        given: "un id"
        String id = "0"
        when:
        artistController.getArtist(id)

        then: "devrai chercher dans la base un artiste"
        1 * artistMongoRepositoryMock.findOne(id)
    }

    def "test get all artists"() {
        when:
        artistController.getArtists()

        then: "devrai chercher dans la base tous les artistes"
        1 * artistMongoRepositoryMock.findAll()
    }
}
