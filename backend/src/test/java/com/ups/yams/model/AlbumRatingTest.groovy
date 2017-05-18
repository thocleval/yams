package com.ups.yams.model

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class AlbumRatingTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test la validite d'un AlbumRating"(String id, int value) {

        given: "un rating"
        AlbumRating rating = new AlbumRating(id: id, value: value)

        expect: "le rating est valide"
        validator.validate(rating).empty

        where:
        id      | value
        "id"    | 1
    }
}
