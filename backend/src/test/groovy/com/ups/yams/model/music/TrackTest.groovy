package com.ups.yams.model.music

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class TrackTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test la validite d'un track"(String name, int trackNumber, int duration) {

        given: "un track"
        Track track = new Track(name: name, trackNumber: trackNumber, duration: duration)

        expect: "l'track est valide"
        validator.validate(track).empty

        where:
        name    | trackNumber   | duration
        "title" | 3             | 300
    }

    @Unroll
    void "test l'invalidité d'un track valide"(String name, int trackNumber, int duration) {

        given: "un track"
        Track track = new Track(name: name, trackNumber: trackNumber, duration: duration)

        expect: "l'track est invalide"
        !validator.validate(track).empty

        where:
        name    | trackNumber   | duration
        ""      | 3             | 300
        null    | 3             | 300
        "title" | 0             | 300
        "title" | -12           | 300
        "title" | 3             | 0
        "title" | 3             | -12

    }

    def "test track getters"(String id, String name, int trackNumber, int duration) {
        given: "un track"
        Track track = new Track(id: id, name: name, trackNumber: trackNumber, duration: duration)

        expect: "les getters de l'track renvoient les bonnes valeurs"
        track.getName().equals(name)
        track.getTrackNumber() == trackNumber
        track.getDuration() == duration
        track.getId() == id

        where:
        id      | name    | trackNumber   | duration
        "id"    | "title" | 3             | 300
    }
}
