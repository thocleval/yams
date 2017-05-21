package com.ups.yams.model.like

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class LikeTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    void "test la validite d'un like"() {

        given: "un like"
        String id = "id"
        Like like = new Like(id: id)

        expect: "le like est valide"
        validator.validate(like).empty
    }

    /*@Unroll
    void "test l'invalidité d'un like"() {

        given: "un like"
        String id = null
        Like like = new Like(id: id)

        expect: "le ratin est invalide"
        !validator.validate(like).empty
    }*/

    def "test like getters"() {
        given: "un like"
        String id = "id"
        Like like = new Like(id: id)

        expect: "les getters d'un like renvoient les bonnes valeurs"
        like.getId().equals(id)
    }
}
