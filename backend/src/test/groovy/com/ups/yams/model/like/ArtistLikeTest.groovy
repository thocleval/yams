package com.ups.yams.model.like

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class ArtistLikeTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    void "test la validite d'un Artistlike"() {

        given: "un like"
        String id = "id"
        ArtistLike like = new ArtistLike(id: id)

        expect: "le like est valide"
        validator.validate(like).empty
    }
}
