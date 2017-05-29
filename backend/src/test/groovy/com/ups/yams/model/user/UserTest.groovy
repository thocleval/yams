package com.ups.yams.model.user

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class UserTest extends Specification {


    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test la validite d'un user valide ayant pour nom UserName"(String name, String email, String password, String profilePicture, List likes, List ratings) {

        given: "un user initialise avec un nom non vide, une date, une coverPicture, une duration, un Streaming link"
        User user = new User(name: name, email: email, password: password, profilePicture: profilePicture, likes: likes, ratings: ratings)

        expect: "l'user est valide"
        validator.validate(user).empty

        where:
        name        | email          | password         | profilePicture    | likes         | ratings
        "UserName"  |"user@name.com" | "password123"    | "moiALaPlage.jpg" | Mock(List)    | Mock(List)
        "UserName"  |"user@name.com" | "password123"    | ""                | Mock(List)    | null
        "UserName"  |"user@name.com" | "password123"    | null              | null          | Mock(List)
        "UserName"  |"user@name.com" | "password123"    | null              | null          | null

    }

    @Unroll
    void "test l'invalidite d'un user non valide"(String name, String email, String password) {

        given: "une activite initialise avec un nom vide"
        User user = new User(name: name, email: email, password: password)

        expect: "l'user est invalide"
        !validator.validate(user).empty

        where:
        name        | email          | password
        ""          |"user@name.com" | "password123"
        null        |"user@name.com" | "password123"
        "UserName"  |""              | "password123"
        "UserName"  |null            | "password123"
        "UserName"  |"monEmail"      | "password123"
        "UserName"  |"user@name.com" | ""
        "UserName"  |"user@name.com" | null
        "UserName"  |"user@name.com" | "pa12"
        "UserName"  |"user@name.com" | "passworddddddd"
        "UserName"  |"user@name.com" | "12345678898765"
    }

    def "test user setters"(String id, String name, String email, String password, String profilePicture, List likes, List ratings) {
        given: "un user"
        User user = new User(id: id, name: name, email: email, password: password, profilePicture: profilePicture, likes: likes, ratings: ratings)

        expect: "les getters de l'user renvoient les bonnes valeurs"
        user.getId().equals(id)
        user.getName().equals(name)
        user.getEmail().equals(email)
        user.getPassword().equals(password)
        user.getProfilePicture().equals(profilePicture)
        user.getLikes() == likes
        user.getRatings() == ratings

        where:
        id          | name        | email          | password         | profilePicture    | likes         | ratings
        "id"        | "UserName"  |"user@name.com" | "password123"    | "moiALaPlage.jpg" | Mock(List)    | Mock(List)
    }
}
