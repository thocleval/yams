package com.ups.yams.model

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
    void "test la validite d'un Tracklike"() {

        given: "un like"
        String id = "id"
        TrackLike like = new TrackLike(id: id)

        expect: "le like est valide"
        validator.validate(like).empty
    }
}
