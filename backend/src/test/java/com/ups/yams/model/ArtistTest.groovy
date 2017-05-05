package com.ups.yams.model

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
    void "test la validite d'un artiste"(String name, String biography, String urlImage) {

        given: "un artiste"
        Artist artist = new Artist(name: name, biography: biography, url: urlImage)

        expect: "l'artiste est valide"
        validator.validate(artist).empty

        where:
        name    | biography     | urlImage
        "name1" | "bio 1"       | null
        "name2" | "bio 2"       | "url"

    }

    @Unroll
    void "test l'invalidité d'un artiste valide"(String name, String biography, String urlImage) {

        given: "un artiste"
        Artist artist = new Artist(name: name, biography: biography, url: urlImage)

        expect: "l'artiste est invalide"
        !validator.validate(artist).empty

        where:
        name    | biography     | urlImage
        null    | null     | null
        null    | "bio1"   | null
        "name1" | null     | null
        null    | "bio1"   | "url"
        "name1" | null     | "url"
        "" | null     | null
        null    | ""   | null
        null | null     | ""

    }

    def "test artist getters"(String name, String biography, String urlImage) {
        given: "un artiste"
        Artist artist = new Artist(name: name, biography: biography, url: urlImage)

        expect: "les getters de l'artiste renvoient les bonnes valeurs"
        artist.getBiography().equals(biography)
        artist.getName().equals(name)
        artist.getUrl().equals(urlImage)

        where:
        name    | biography     | urlImage
        "name2" | "bio 2"       | "url"
    }
}
