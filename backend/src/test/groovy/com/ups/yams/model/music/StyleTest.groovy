package com.ups.yams.model.music

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class StyleTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test la validite d'un style"(String name, String description) {

        given: "un style"
        Style style = new Style(name: name, description: description)

        expect: "l'style est valide"
        validator.validate(style).empty

        where:
        name    | description
        "name1" | "bio 1"
        "name1" | ""
        "name1" | null
    }

    @Unroll
    void "test l'invalidité d'un style valide"(String name, String description) {

        given: "un style"
        Style style = new Style(name: name, description: description)

        expect: "l'style est invalide"
        !validator.validate(style).empty

        where:
        name    | description
        ""      | "bio 1"
        ""      | ""
        ""      | null
        null    | "bio 1"
        null    | ""
        null    | null

    }

    def "test style getters"(String name, String description) {
        given: "un style"
        Style style = new Style(name: name, description: description)

        expect: "les getters de l'style renvoient les bonnes valeurs"
        style.getName().equals(name)
        style.getDescription().equals(description)

        where:
        name    | description
        "name1" | "bio 1"
    }
}
