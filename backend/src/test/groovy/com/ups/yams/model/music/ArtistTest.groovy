package com.ups.yams.model.music

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.ValidatorFactory
import javax.validation.Validator

class ArtistTest extends Specification {

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test la validite d'un artiste"(String id, String name, String biography, String avatar, String cover, List albums, Nationality nationality) {

        given: "un artiste"
        Artist artist = new Artist(id: id, name: name, biography: biography, avatar: avatar, cover: cover, albums: albums, nationality: nationality)

        expect: "l'artiste est valide"
        validator.validate(artist).empty

        where:
        id      | name    | biography     | avatar      | cover      | albums        | nationality
        "id1"   | "name1" | "bio 1"       | null        | null       | Mock(List)    | Mock(Nationality)
        null    | "name2" | "bio 2"       | "url"       | "url"      | null          | null
        "id2"   | "name1" | "bio 1"       | null        | null       | Mock(List)    | Mock(Nationality)
        null    | "name2" | "bio 2"       | "url"       | "url"      | null          | null

    }

    @Unroll
    void "test l'invalidité d'un artiste valide"(String name, String biography, String avatar, String cover, List albums, Nationality nationality) {

        given: "un artiste"
        Artist artist = new Artist(name: name, biography: biography, avatar: avatar, cover: cover, albums: albums, nationality: nationality)

        expect: "l'artiste est invalide"
        !validator.validate(artist).empty

        where:
        name    | biography     | avatar    | cover     | albums        | nationality
        null    | null          | null      | null      | Mock(List)    | Mock(Nationality)
        null    | "bio1"        | null      | null      | null          | null
        "name1" | null          | null      | null      | Mock(List)    | Mock(Nationality)
        null    | "bio1"        | "url"     | "url"     | null          | null
        "name1" | null          | "url"     | "url"     | Mock(List)    | Mock(Nationality)
        ""      | null          | null      | null      | null          | null
        null    | ""            | null      | null      | Mock(List)    | Mock(Nationality)
        null    | null          | ""        | ""        | null          | null

    }

    def "test artist getters"(String id, String name, String biography, String avatar, String cover, List albums, Nationality nationality) {
        given: "un artiste"
        Artist artist = new Artist(id: id, name: name, biography: biography, avatar: avatar, cover: cover, albums: albums, nationality: nationality)

        expect: "les getters de l'artiste renvoient les bonnes valeurs"
        artist.getId().equals(id)
        artist.getBiography().equals(biography)
        artist.getName().equals(name)
        artist.getAvatar().equals(avatar);
        artist.getCover().equals(cover);
        artist.getAlbums() == albums
        artist.getNationality() == nationality

        where:
        id      | name    | biography     | avatar      | cover       | albums        | nationality
        "id"    | "name2" | "bio 2"       | "url"       | "url"       | Mock(List)    | Mock(Nationality)
    }
}
