package com.ups.yams.model

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class AlbumTest extends Specification {

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test la validite d'un album valide ayant pour nom AlbumName"(String aName, Date aDate, String aCoverPicture, int aDuration, String aStreamingLink) {

        given: "un album initialise avec un nom non vide, une date, une coverPicture, une duration, un Streaming link"
        Album album = new Album(name: aName, releaseDate: aDate, coverPicture: aCoverPicture, duration: aDuration, streamingLink: aStreamingLink)

        expect: "l'album est valide"
        validator.validate(album).empty

        where:
        aName        | aDate     | aCoverPicture         | aDuration     | aStreamingLink
        "AlbumName"  |new Date() | "coverPicture.jpg"    | 180           | "deezer.com"
        "AlbumName"  |new Date() | "coverPicture.jpg"    | 180           | null
        "AlbumName"  |new Date() | "coverPicture.jpg"    | 180           | ""
        "AlbumName"  |new Date() | null                  | 180           | "deezer.com"
        "AlbumName"  |new Date() | null                  | 180           | null
        "AlbumName"  |new Date() | null                  | 180           | ""
        "AlbumName"  |new Date() | ""                    | 180           | "deezer.com"
        "AlbumName"  |new Date() | ""                    | 180           | null
        "AlbumName"  |new Date() | ""                    | 180           | ""

    }

    @Unroll
    void "test l'invalidite d'un album non valide"(String aName, Date aDate, int aDuration) {

        given: "une activite initialise avec un nom vide"
        Album album = new Album(name: aName, releaseDate: aDate, duration: aDuration)

        expect: "l'album est invalide"
        !validator.validate(album).empty

        where:
        aName        | aDate     | aDuration
        "AlbumName"  |new Date() | 0
        "AlbumName"  |new Date() | -5
        "AlbumName"  |null       | 0
        "AlbumName"  |null       | -5
        "AlbumName"  |null       | 180
        ""           |new Date() | 0
        ""           |new Date() | -5
        ""           |new Date() | 180
        ""           |null       | 0
        ""           |null       | -5
        ""           |null       | 180
        null         |new Date() | 0
        null         |new Date() | -5
        null         |new Date() | 180
        null         |null       | 0
        null         |null       | -5
        null         |null       | 180
    }

    def "test artist setters"(String aName, Date aDate, String aCoverPicture, int aDuration, String aStreamingLink) {
        given: "un album"
        Album album = new Album(name: aName, releaseDate: aDate, coverPicture: aCoverPicture, duration: aDuration, streamingLink: aStreamingLink)

        expect: "les getters de l'album renvoient les bonnes valeurs"
        album.getName().equals(aName)
        album.getReleaseDate().equals(aDate)
        album.getCoverPicture().equals(aCoverPicture)
        album.getDuration() == (aDuration)
        album.getStreamingLink().equals(aStreamingLink)

        where:
        aName        | aDate     | aCoverPicture         | aDuration     | aStreamingLink
        "AlbumName"  |new Date() | "coverPicture.jpg"    | 180           | "deezer.com"
    }
}
