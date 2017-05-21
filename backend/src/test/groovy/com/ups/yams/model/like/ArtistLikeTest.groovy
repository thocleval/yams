package com.ups.yams.model.like

import com.ups.yams.model.music.Artist
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class ArtistLikeTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    void "test la validite d'un Artistlike"(String id, Artist artist) {

        given: "un like"
        ArtistLike like = new ArtistLike(id: id, artist: artist)

        expect: "le like est valide"
        validator.validate(like).empty

        where:
        id      | artist
        "id"    | Mock(Artist)
    }

    @Unroll
    void "test l'invalidite d'un Artistlike"(String id, Artist artist) {

        given: "un like"
        ArtistLike like = new ArtistLike(id: id, artist: artist)

        expect: "le like est valide"
        !validator.validate(like).empty

        where:
        id      | artist
        "id"    | null
    }

    def "test artistLike getters"() {
        given: "un like"
        String id = "id"
        Artist artist = Mock(Artist)
        ArtistLike like = new ArtistLike(id: id, artist: artist)

        expect: "les getters d'un artistLike renvoient les bonnes valeurs"
        like.getId().equals(id)
        like.getArtist() == artist
    }
}

