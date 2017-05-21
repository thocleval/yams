package com.ups.yams.model.like

import com.ups.yams.model.music.Album
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class AlbumLikeTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    void "test la validite d'un Albumlike"(String id, Album album) {

        given: "un like"
        AlbumLike like = new AlbumLike(id: id, album: album)

        expect: "le like est valide"
        validator.validate(like).empty

        where:
        id      | album
        "id"    | Mock(Album)
    }

    @Unroll
    void "test l'invalidite d'un Albumlike"(String id, Album album) {

        given: "un like"
        AlbumLike like = new AlbumLike(id: id, album: album)

        expect: "le like est valide"
        !validator.validate(like).empty

        where:
        id      | album
        "id"    | null
    }

    def "test albumLike getters"(String id, Album album) {
        given: "un like"
        AlbumLike like = new AlbumLike(id: id, album: album)

        expect: "les getters d'un albumLike renvoient les bonnes valeurs"
        like.getId().equals(id)
        like.getAlbum() == album

        where:
        id      | album
        "id"    | Mock(Album)
    }
}
