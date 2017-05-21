package com.ups.yams.model.like

import com.ups.yams.model.music.Track
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class TrackLikeTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    void "test la validite d'un Tracklike"(String id, Track track) {

        given: "un like"
        TrackLike like = new TrackLike(id: id, track: track)

        expect: "le like est valide"
        validator.validate(like).empty

        where:
        id      | track
        "id"    | Mock(Track)
    }

    @Unroll
    void "test l'invalidite d'un Tracklike"(String id, Track track) {

        given: "un like"
        TrackLike like = new TrackLike(id: id, track: track)

        expect: "le like est valide"
        !validator.validate(like).empty

        where:
        id      | track
        "id"    | null
    }

    def "test trackLike getters"(String id, Track track) {
        given: "un like"
        TrackLike like = new TrackLike(id: id, track: track)

        expect: "les getters d'un trackLike renvoient les bonnes valeurs"
        like.getId().equals(id)
        like.getTrack() == track

        where:
        id      | track
        "id"    | Mock(Track)
    }
}
