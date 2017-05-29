package com.ups.yams.model.music

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
    void "test la validite d'un album valide ayant pour nom AlbumName"(String aName, Date aDate, String aCoverPicture, int aDuration, String aStreamingLink, List tracks, Style style) {

        given: "un music initialise avec un nom non vide, une date, une coverPicture, une duration, un Streaming link"
        Album album = new Album(name: aName, releaseDate: aDate, coverPicture: aCoverPicture, duration: aDuration, streamingLink: aStreamingLink, tracks: tracks, style: style)

        expect: "l'music est valide"
        validator.validate(album).empty

        where:
        aName        | aDate     | aCoverPicture         | aDuration     | aStreamingLink   | tracks        | style
        "AlbumName"  |new Date() | "coverPicture.jpg"    | 180           | "deezer.com"     | Mock(List)    | Mock(Style)
        "AlbumName"  |new Date() | "coverPicture.jpg"    | 180           | null             | null          | null
        "AlbumName"  |new Date() | "coverPicture.jpg"    | 180           | ""               | Mock(List)    | Mock(Style)
        "AlbumName"  |new Date() | null                  | 180           | "deezer.com"     | null          | null
        "AlbumName"  |new Date() | null                  | 180           | null             | Mock(List)    | Mock(Style)
        "AlbumName"  |new Date() | null                  | 180           | ""               | null          | null
        "AlbumName"  |new Date() | ""                    | 180           | "deezer.com"     | Mock(List)    | Mock(Style)
        "AlbumName"  |new Date() | ""                    | 180           | null             | null          | null
        "AlbumName"  |new Date() | ""                    | 180           | ""               | Mock(List)    | Mock(Style)

    }

    @Unroll
    void "test l'invalidite d'un album non valide"(String aName, Date aDate, int aDuration, String aStreamingLink, List tracks, Style style) {

        given: "une activite initialise avec un nom vide"
        Album album = new Album(name: aName, releaseDate: aDate, duration: aDuration, streamingLink: aStreamingLink, tracks: tracks, style: style)

        expect: "l'music est invalide"
        !validator.validate(album).empty

        where:
        aName        | aDate     | aDuration | aStreamingLink   | tracks        | style
        "AlbumName"  |new Date() | 0         | "deezer.com"     | Mock(List)    | Mock(Style)
        "AlbumName"  |new Date() | -5         | "deezer.com"    | null          | null
        "AlbumName"  |null       | 0         | "deezer.com"     | Mock(List)    | Mock(Style)
        "AlbumName"  |null       | -5         | "deezer.com"    | null          | null
        "AlbumName"  |null       | 180         | "deezer.com"   | Mock(List)    | Mock(Style)
        ""           |new Date() | 0         | "deezer.com"     | null          | null
        ""           |new Date() | -5         | "deezer.com"    | Mock(List)    | Mock(Style)
        ""           |new Date() | 180         | "deezer.com"   | null          | null
        ""           |null       | 0         | "deezer.com"     | Mock(List)    | Mock(Style)
        ""           |null       | -5         | "deezer.com"    | null          | null
        ""           |null       | 180         | "deezer.com"   | Mock(List)    | Mock(Style)
        null         |new Date() | 0         | "deezer.com"     | null          | null
        null         |new Date() | -5         | "deezer.com"    | Mock(List)    | Mock(Style)
        null         |new Date() | 180         | "deezer.com"   | null          | null
        null         |null       | 0         | "deezer.com"     | Mock(List)    | Mock(Style)
        null         |null       | -5         | "deezer.com"    | null          | null
        null         |null       | 180         | "deezer.com"   | Mock(List)    | Mock(Style)
    }

    def "test artist setters"(String id, String aName, Date aDate, String aCoverPicture, int aDuration, String aStreamingLink, List tracks, Style style) {
        given: "un music"
        Album album = new Album(id: id, name: aName, releaseDate: aDate, coverPicture: aCoverPicture, duration: aDuration, streamingLink: aStreamingLink, tracks: tracks, style: style)

        expect: "les getters de l'music renvoient les bonnes valeurs"
        album.getId().equals(id)
        album.getName().equals(aName)
        album.getReleaseDate().equals(aDate)
        album.getCoverPicture().equals(aCoverPicture)
        album.getStreamingLink().equals(aStreamingLink)
        album.getDuration() == aDuration
        album.getTracks() == tracks
        album.getStyle() == style

        where:
        id          | aName        | aDate                            | aCoverPicture         | aDuration     | aStreamingLink  | tracks        | style
        "id"        | "AlbumName"  | new Date(2017, 01, 01) | "coverPicture.jpg"    | 180           | "deezer.com"    | Mock(List)    | Mock(Style)
    }
}
