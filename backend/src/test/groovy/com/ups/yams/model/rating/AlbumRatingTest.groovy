package com.ups.yams.model.rating

import com.ups.yams.model.music.Album
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class AlbumRatingTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    void "test la validite d'un AlbumRating"(String id, int value, Album album) {

        given: "un rating"
        AlbumRating rating = new AlbumRating(id: id, value: value, album: album)

        expect: "le rating est valide"
        validator.validate(rating).empty

        where:
        id   | value | album
        "id" | 1     | Mock(Album)
    }

    @Unroll
    void "test l'invalidite d'un AlbumRating"(String id, int value, Album album) {

        given: "un rating"
        AlbumRating rating = new AlbumRating(id: id, value: value, album: album)

        expect: "le rating est invalide"
        !validator.validate(rating).empty

        where:
        id      | value | album
        "id"    | 1     | null
        "id"    | -1     | null
        "id"    | -6     | null
        "id"    | -1     | Mock(Album)
        "id"    | -6     | Mock(Album)
    }

    def "test albumRating getters"(String id, int value, Album album) {
        given: "un like"
        AlbumRating rating = new AlbumRating(id: id, value: value, album: album)

        expect: "les getters d'un albumrating renvoient les bonnes valeurs"
        rating.getId().equals(id)
        rating.getValue() == value
        rating.getAlbum() == album

        where:
        id   | value | album
        "id" | 1     | Mock(Album)
    }
}
