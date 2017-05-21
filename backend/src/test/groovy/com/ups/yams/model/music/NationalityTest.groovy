package com.ups.yams.model.music

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class NationalityTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test la validite d'un nationality"(String name, String flag) {

        given: "un nationality"
        Nationality nationality = new Nationality(name: name, flag: flag)

        expect: "l'nationality est valide"
        validator.validate(nationality).empty

        where:
        name    | flag
        "france" | "fr.png"
    }

    @Unroll
    void "test l'invalidité d'un nationality valide"(String name, String flag) {

        given: "un nationality"
        Nationality nationality = new Nationality(name: name, flag: flag)

        expect: "l'nationality est invalide"
        !validator.validate(nationality).empty

        where:
        name    | flag
        ""      | "fr.png"
        null    | "fr.png"
        ""      | ""
        null    | null
        "france"| ""
        "france"| null

    }

    def "test nationality getters"(String name, String flag) {
        given: "un nationality"
        Nationality nationality = new Nationality(name: name, flag: flag)

        expect: "les getters de l'nationality renvoient les bonnes valeurs"
        nationality.getName().equals(name)
        nationality.getFlag().equals(flag)

        where:
        name    | flag
        "name1" | "fr.png"
    }
}
