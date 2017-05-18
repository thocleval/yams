package com.ups.yams.model.rating

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class RatingTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test la validite d'un rating"(String id, int value) {

        given: "un rating"
        Rating rating = new Rating(id: id, value: value)

        expect: "le rating est valide"
        validator.validate(rating).empty

        where:
        id      | value
        "id"    | 1
    }

    @Unroll
    void "test l'invalidité d'un rating"(String id, int value) {

        given: "un rating"
        Rating rating = new Rating(id: id, value: value)

        expect: "le ratin est invalide"
        !validator.validate(rating).empty

        where:
        id      | value
        "id"    | -1
        "id"    | 6
    }

    def "test rating getters"(String id, int value) {
        given: "un rating"
        Rating rating = new Rating(id: id, value: value)

        expect: "les getters d'un rating renvoient les bonnes valeurs"
        rating.getId().equals(id)
        rating.getValue() == value

        where:
        id      | value
        "id"    | 1
    }
}
