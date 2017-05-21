package com.ups.yams.model.rating

import com.ups.yams.model.music.Track
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class TrackRatingTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    void "test la validite d'un TrackRating"(String id, int value, Track track) {

        given: "un rating"
        TrackRating rating = new TrackRating(id: id, value: value, track: track)

        expect: "le rating est valide"
        validator.validate(rating).empty

        where:
        id   | value | track
        "id" | 1     | Mock(Track)
    }

    @Unroll
    void "test l'invalidite d'un TrackRating"(String id, int value, Track track) {

        given: "un rating"
        TrackRating rating = new TrackRating(id: id, value: value, track: track)

        expect: "le rating est invalide"
        !validator.validate(rating).empty

        where:
        id      | value  | track
        "id"    | 1      | null
        "id"    | -1     | null
        "id"    | -6     | null
        "id"    | -1     | Mock(Track)
        "id"    | -6     | Mock(Track)
    }

    def "test trackRating getters"(String id, int value, Track track) {
        given: "un like"
        TrackRating rating = new TrackRating(id: id, value: value, track: track)

        expect: "les getters d'un trackrating renvoient les bonnes valeurs"
        rating.getId().equals(id)
        rating.getValue() == value
        rating.getTrack() == track

        where:
        id   | value | track
        "id" | 1     | Mock(Track)
    }
}
